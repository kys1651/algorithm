import java.io.*;
import java.util.*;

public class Main {
    static long[] answer;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        answer = new long[65];
        dp = new long[65][10];
        Arrays.fill(dp[1], 1);

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            if(answer[N] == 0){
                for (int i = 9; i >= 0; i--) {
                    answer[N] += solve(N, i);
                }
            }
            sb.append(answer[N]).append('\n');
        }
        System.out.println(sb);
    }

    private static long solve(int x, int y) {
        if(x < 0 || y < 0) return 0;
        if(dp[x][y] != 0) return dp[x][y];
        return dp[x][y] = solve(x - 1, y) + solve(x, y - 1);
    }
}