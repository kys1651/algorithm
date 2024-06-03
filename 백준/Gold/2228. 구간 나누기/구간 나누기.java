import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Input
        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(br.readLine());
        }// Input End

        /*
            배열을 이루는 수 = -32768
            N의 최대값 101(1 ~100)개
            결과의 최소값 = -32768 * 101
         */
        int[][] dp = new int[K + 1][N + 1];
        int MIN = -32768 * 101;
        for (int i = 1; i <= K; i++) {
            // 0번째 인덱스에도 최소값을 박아놔야
            for (int j = 0; j <= N; j++) {
                dp[i][j] = MIN;
            }
        }

        dp[1][1] = sum[1];
        for (int i = 1; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                // 직전값이 포함된 경우 = 현재 값이 포함되지 않은 경우
                dp[i][j] = dp[i][j - 1];

                // i = 1인 경우는 구간이 하나라는 뜻임으로 누적합과도 비교해주어야 함
                if (i == 1) dp[i][j] = Math.max(dp[i][j], sum[j]);
                for (int l = 0; l <= j - 2; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][l] + sum[j] - sum[l + 1]);
                }
            }
        }
        System.out.println(dp[K][N]);


    }
}