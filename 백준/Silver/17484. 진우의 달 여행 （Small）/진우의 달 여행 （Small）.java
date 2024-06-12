import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int DOWN = 0, RIGHT = 1, LEFT = 2;
    static int[][][] dp;
    static int[][] value;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // Input
        value = new int[N][M];
        dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                value[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 1000;
                }
            }
        } // Input End

        // 첫 번째 행 초기화
        for (int j = 0; j < M; j++) {
            dp[0][j][DOWN] = value[0][j];
            dp[0][j][RIGHT] = value[0][j];
            dp[0][j][LEFT] = value[0][j];
        }

        // 두 번째 행부터 시작
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j > 0) {
                    dp[i][j][LEFT] = Math.min(dp[i][j][LEFT], dp[i - 1][j - 1][DOWN] + value[i][j]);
                    dp[i][j][LEFT] = Math.min(dp[i][j][LEFT], dp[i - 1][j - 1][RIGHT] + value[i][j]);
                }
                if (j < M - 1) {
                    dp[i][j][RIGHT] = Math.min(dp[i][j][RIGHT], dp[i - 1][j + 1][DOWN] + value[i][j]);
                    dp[i][j][RIGHT] = Math.min(dp[i][j][RIGHT], dp[i - 1][j + 1][LEFT] + value[i][j]);
                }
                dp[i][j][DOWN] = Math.min(dp[i][j][DOWN], dp[i - 1][j][LEFT] + value[i][j]);
                dp[i][j][DOWN] = Math.min(dp[i][j][DOWN], dp[i - 1][j][RIGHT] + value[i][j]);
            }
        }

        int answer = 1000;
        for (int j = 0; j < M; j++) {
            answer = Math.min(answer, dp[N - 1][j][DOWN]);
            answer = Math.min(answer, dp[N - 1][j][LEFT]);
            answer = Math.min(answer, dp[N - 1][j][RIGHT]);
        }
        System.out.println(answer);
    }
}