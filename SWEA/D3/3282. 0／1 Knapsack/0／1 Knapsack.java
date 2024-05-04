import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] dp = new int[K + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int weight = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                for (int j = K; j >= weight; j--) {
                    dp[j] = Math.max(dp[j], dp[j - weight] + value);
                }
            }
            sb.append(String.format("#%d %d\n", tc, dp[K]));
        }
        System.out.println(sb);
    }
}