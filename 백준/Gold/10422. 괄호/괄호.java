import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int SIZE = 5000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // 범위까지 미리 구해놓기
        long[] dp = new long[SIZE + 1];
        dp[0] = dp[2] = 1;
        for (int i = 2; i <= SIZE / 2; i++) {
            for (int j = 0; j < i; j++) {
                dp[i * 2] += (dp[j * 2] * dp[(i - 1 - j) * 2]) % 1000_000_007L;
            }
            dp[i * 2] %= 1000_000_007L;
        }

        for (int tc = 1; tc <= T; tc++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }

        System.out.println(sb);
    }
}

