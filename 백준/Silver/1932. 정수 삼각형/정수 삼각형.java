import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int [][] arr;
    static Integer [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new Integer[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {

                // 현재 값이 가장 왼쪽 값일 때는 오른쪽 값을 넣어준다.
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                    continue;
                }

                // 현재 값이 가장 오른쪽 일 때는 왼쪽 값을 넣어준다.
                if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                    continue;
                }

                // 왼쪽 값
                int left = dp[i-1][j-1] ;
                // 오른쪽 값
                int right = dp[i - 1][j];

                dp[i][j] = Math.max(left, right) + arr[i][j];
            }
        }

        int result = dp[N - 1][0];
        for (int i = 1; i < N; i++) {
            result = Math.max(result, dp[N - 1][i]);
        }

        System.out.println(result);
    }
}
