import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][N + 1];
        // K가 1 -> 1로 만들 수 있는 수는 무조건 1개
        Arrays.fill(dp[1], 1);

        // 0은 K개라면 무조건 1개씩은 만든다.
        for (int i = 0; i <= K; i++) {
            dp[i][0] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1])  % MOD;
            }
        }
        System.out.println(dp[K][N]);
    }
}