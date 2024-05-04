import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] input = br.readLine().split(" ");
            String A = input[0];
            String B = input[1];
            int lenA = A.length();
            int lenB = B.length();
            int[][] dp = new int[lenA + 1][lenB + 1];
            for (int i = 1; i <= lenA; i++) {
                for (int j = 1; j <= lenB; j++) {
                    if (A.charAt(i-1) == B.charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            sb.append(String.format("#%d %d\n", tc, dp[lenA][lenB]));
        }
        System.out.println(sb);
    }
}