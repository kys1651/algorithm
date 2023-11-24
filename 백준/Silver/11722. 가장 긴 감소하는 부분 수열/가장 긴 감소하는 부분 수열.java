import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        
        for(int i = 1; i <= n ;i++){
            int val = 0;
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i] && dp[j] > val){
                    val = dp[j];
                }
            }
            dp[i] = val + 1;
            result = Math.max(dp[i],result);
        }
        System.out.println(result);

    }
}