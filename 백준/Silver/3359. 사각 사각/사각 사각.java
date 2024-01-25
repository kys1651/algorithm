import java.util.*;
import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][2];
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 사각형 변을 a,b로 둔다.
        // [0] => a가 윗변 b가 높이인 경우
        // [1] => b가 윗변 a가 높이인 경우
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        for (int i = 2; i <= n; i++) {
            // 현재 a가 윗변이고 이전 사각형은 a가 윗변인 경우
            int a = Math.abs(arr[i - 1][0] - arr[i][1]) + arr[i][0] + dp[i - 1][1];
            // 현재 a가 윗변이고 이전 사각형은 b가 윗변인 경우
            int b = Math.abs(arr[i - 1][1] - arr[i][1]) + arr[i][0] + dp[i - 1][0];
            dp[i][0] = Math.max(a, b);

            // 현재 b가 윗변이고 이전 사각형은 a가 윗변인 경우
            a = Math.abs(arr[i - 1][1] - arr[i][0]) + arr[i][1] + dp[i - 1][0];
            // 현재 a가 윗변이고 이전 사각형은 b가 윗변인 경우
            b = Math.abs(arr[i - 1][0] - arr[i][0]) + arr[i][1] + dp[i - 1][1];
            dp[i][1] = Math.max(a, b);
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}