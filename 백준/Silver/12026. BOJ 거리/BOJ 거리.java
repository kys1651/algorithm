import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int[] arr = new int[line.length()];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.MAX_VALUE;
        }
        arr[0] = 0;
        
        char next;
        for(int i = 0; i < line.length(); i++){
            char cur = line.charAt(i);
            if(arr[i] == Integer.MAX_VALUE){
                continue;
            }
            if(cur == 'B'){
                next = 'O';
            }else if(cur =='O'){
                next = 'J';
            }else{
                next = 'B';
            }
            for(int j = i + 1; j < line.length(); j++){
                if(line.charAt(j) == next){
                    int nextValue = arr[i] + (j - i) * (j - i);
                    arr[j] = Math.min(arr[j],nextValue);
                }
            }
        }
        
        bw.write((arr[n-1] == Integer.MAX_VALUE ? -1 : arr[n-1]) +"\n");
        bw.flush();
        bw.close();
    }
    
}