import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        for(int i = 0; i < 10; i++ ){
            dp[0][i] = 1;
        }

        for(int i = 1; i <= n; i++){
            dp[i][9] = 1;
            for(int j = 8; j >= 0; j--){
                dp[i][j] = (dp[i][j+1] + dp[i-1][j]) % 10007;
            }
        }
        int result = 0;
        for(int i = 0; i < 10; i++){
            result = (result + dp[n-1][i]) % 10007;
        }
        System.out.println(result);
    }
}