import java.util.*;
import java.io.*;

 class Solution {
    static int[][] dp;
    static final int MOD = 1_000_000_007;
    static final int SIZE = 16;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String manager = br.readLine();
            dp = new int[manager.length() + 1][SIZE];
            sb.append('#').append(tc).append(' ').append(solve(manager)).append('\n');
        }
        System.out.println(sb);
    }

    private static int solve(String manager) {
        int firstManager = (1 << manager.charAt(0) - 'A');
        // 1일차 초기화
        for (int i = 1; i < SIZE; i++) {
            // A가 포함되지 않은 경우 넘어간다.
            if ((i & 1) == 0) continue;
            // A와 첫째날 매니저가 겹치지 않은 경우 넘어간다.
            if ((i & firstManager) == 0) continue;
            dp[0][i] = 1;
        }

        int len = manager.length();

        for (int i = 1; i < len; i++) {
            int m = 1 << (manager.charAt(i) - 'A');
            for (int j = 1; j < SIZE; j++) { // 오늘
                for (int k = 1; k < SIZE; k++) { // 어제
                    // 담당자가 포함되지 않은 오늘이라면 넘어간다.
                    if ((j & m) == 0) continue;
                    // 어제와 오늘의 겹치는 조원이 한명이라도 없다면 넘어간다.
                    if ((j & k) == 0) continue;
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }

        int ret = 0;
        for (int i = 1; i < 16; i++) {
            ret = (ret + dp[len - 1][i]) % MOD;
        }
        return ret;
    }
}