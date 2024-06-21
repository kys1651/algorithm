import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: BOJ_1958_LCS3
 * 메모리: 17676KB
 * 시간: 140ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        System.out.println(getLCS(a, b, c));
    }

    private static int getLCS(String a, String b, String c) {
        int aLen = a.length(), bLen = b.length(), cLen = c.length();
        int[][][] dp = new int[aLen + 1][bLen + 1][cLen + 1];
        for (int i = 1; i <= aLen; i++) {
            char aChar = a.charAt(i - 1);
            for (int j = 1; j <= bLen; j++) {
                char bChar = b.charAt(j - 1);
                for (int k = 1; k <= cLen; k++) {
                    char cChar = c.charAt(k - 1);
                    if (aChar == bChar && bChar == cChar) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }
        return dp[aLen][bLen][cLen];
    }
}