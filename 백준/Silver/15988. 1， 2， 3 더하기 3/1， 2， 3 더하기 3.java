import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {

    final static long mod = 1000000009L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 4; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
            }
            sb.append(dp[N] + "\n");
        }

        System.out.println(sb);
    }
}
