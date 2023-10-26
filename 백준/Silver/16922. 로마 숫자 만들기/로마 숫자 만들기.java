import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

class Main
{
    static int[] num = {1,5,10,50};
    static Set<Integer> set = new HashSet<>();
    static int n;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        solution(0,0,0);
        bw.write(set.size() + "\n");
        bw.flush();
        bw.close();
    }
    private static void solution(int at,int depth,int sum) {
        if(depth == n){
            set.add(sum);
            return;
        }

        for(int i = at; i < 4; i++){
            solution(i,depth+1, sum + num[i]);
        }
    }
}