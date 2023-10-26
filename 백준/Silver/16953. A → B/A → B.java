import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        int result = bfs(a,b);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int bfs(long start, long end) {
        Queue<Long> q = new LinkedList<>();
        q.add(start);

        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                long tmp = q.poll();
                if(tmp == end){
                    return count + 1;
                }

                long mul = tmp * 2;
                if(mul <= end){
                    q.add(mul);
                }
                long addOne = tmp * 10 + 1;
                if(addOne <= end){
                    q.add(addOne);
                }
            }
            count++;
        }
        return -1;
    }
}