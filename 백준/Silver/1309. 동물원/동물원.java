import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 경우의 수 3가지 - 현재 위치에 사자를 안놓는 경우[0], 왼쪽에 놓는 경우[1], 오른쪽에 놓는 경우[2]
        int[][] dp = new int[n + 1][3];
        // N = 1일 때는 경우의 수가 모두 1이다.
        dp[1][0] = 1;
        dp[1][1] = 1;
        // 2부터 N까지 진행
        for (int i = 2; i <= n; i++) {
            // 아무것도 놓지 않는 경우는 위에 모든 경우의 수(아무것도 없을 때, 왼쪽일 때, 오른쪽 일 때)를 더한 것.
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] * 2) % MOD;
            // 왼쪽인 경우 - 이전 경우가 아무것도 없을 때, 오른쪽일 때
            // 오른쪽인 경우 - 이전 경우가 아무것도 없을 때, 왼쪽일 때
            // 즉 대칭이므로 아무것도 없을 때 + 왼쪽인 경우만 담음
            dp[i][1] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }
        System.out.println((dp[n][0] + dp[n][1] * 2) % MOD);
    }
}