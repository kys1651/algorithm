import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int zero;
    static int one;
    static int zero_plus_one;
//    static int[][] dp = new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                dp[i][j] = -1;
//            }
//        }
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            fibonacci(n);
            sb.append(zero).append(" ").append(one).append("\n");
        }
        System.out.println(sb);

    }

    private static void fibonacci(int n) {
        zero = 1;
        one = 0;
        zero_plus_one = 1;

        for (int i = 0; i < n; i++) {
            zero = one;
            one = zero_plus_one;
            zero_plus_one = zero + one;
        }
    }
}
