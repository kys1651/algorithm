import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
     static long[] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]) % 1000000007;
            }
            dp[i] %= 1000000007;
        }
        System.out.println(dp[n]);
    }
}

