import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            int idx = (int) Math.sqrt(i);
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
