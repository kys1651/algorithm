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
        int[][] dp = new int[n+1][2];
        
        for(int i = 1; i <= n ;i++){
            int val = 0;
            for(int j = 0; j < i; j++){
                if(dp[j][1] > arr[i] && dp[j][0] > val){
                    val = dp[j][0];
                }
            }
            dp[i][0] = val + 1;
            dp[i][1] = arr[i];
            result = Math.max(dp[i][0],result);
        }
        System.out.println(result);

    }
}