import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int [][] dp;
    static int [][] arr;
    static int answer =0,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            dp = new int[2][n+1];
            arr = new int[2][n+1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());

                // 입력 받기
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }

            }
            // DP
            dp();
            sb.append(answer).append("\n");
        }

        System.out.println(sb);



    }

    private static void dp() {

        dp[0][1] = arr[0][1];
        dp[1][1] = arr[1][1];

        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
        }
        answer = Math.max(dp[0][n], dp[1][n]);
    }
}
