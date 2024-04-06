import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] unit = new int[N + 1];
            // Input
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                unit[i] = Integer.parseInt(st.nextToken());
            }// Input End

            int total = Integer.parseInt(br.readLine());
            int[] dp = new int[total + 1];
            dp[0] = 1;
            for (int i = 1; i <= N; i++) {
                int coin = unit[i];
                for (int j = coin; j <= total; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            sb.append(dp[total]).append('\n');
        }
        System.out.println(sb);
    }
}
