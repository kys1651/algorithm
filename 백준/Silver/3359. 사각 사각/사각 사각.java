import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][2];
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정방향[0], 회전[1]
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        // 현재 모양을 그대로 두고 이전에서 최대값을 구해서 그대로 가지고 간다.
        for (int i = 2; i <= n; i++) {
            // 현재 x * y 모양, a : 이전이 x * y 모양인 경우, b : 이전이 y * x인 경우
            int a = Math.abs(arr[i - 1][1] - arr[i][1]);
            int b = Math.abs(arr[i - 1][0] - arr[i][1]);
            dp[i][0] = Math.max(a + dp[i - 1][0], b + dp[i - 1][1]) + arr[i][0];
            // 현재 y * x 모양, a : 이전이 x * y 모양인 경우, b : 이전이 y * x인 경우
            a = Math.abs(arr[i - 1][1] - arr[i][0]);
            b = Math.abs(arr[i - 1][0] - arr[i][0]);
            dp[i][1] = Math.max(a  + dp[i - 1][0] , b  + dp[i - 1][1]) + arr[i][1];
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}