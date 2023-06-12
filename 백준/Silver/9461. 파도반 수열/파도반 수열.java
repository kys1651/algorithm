import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(triangle(n));
        }
    }

    private static long triangle(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = triangle(n-2) + triangle(n-3);

        return dp[n];
    }

}
