import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[k + 1][n + 1];

        // N을 0개로 만들 수 있는 값은 0개 - 존재하지 않음
        // N을 1개로 만들 수 있는 값은 1개 - 해당 숫자 한개
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }

        // 0을 만들 수 있는 경우의 수는 0 + 0 + 0 + ,,,으로 1개
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1;
        }

        // 1을 만드는 경우 : 0을 두개로 만드는 경우 + 1을 1개로 만드는 경우
        // 2를 만드는 경우 : 1을 두개로 만드는 경우 + 2를 1개로 만드는 경우
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }
        System.out.println(dp[k][n]);
    }
}