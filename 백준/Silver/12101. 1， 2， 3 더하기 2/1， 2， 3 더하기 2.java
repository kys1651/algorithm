import java.util.*;
import java.io.*;

public class Main {
    static String[][] num = {
            {},
            {"1"},
            {"1+1", "2"},
            {"1+1+1", "1+2", "2+1", "3"}
    };
    static int n, k, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int value = 7;
        for (int i = 4; i < 11; i++) {
            dp[i] = value;
            value += dp[i];
        }
//        if (dp[n] < k) {
//            System.out.println(-1);
//        }
        searchPlus(0, "");
        System.out.println(-1);
    }

    static void searchPlus(int sum, String text) {
        if (sum > n) {
            return;
        }
        if (sum == n) {
            count++;
            if (count == k) {
                System.out.println(text.substring(0,text.length()-1));
                System.exit(0);
            }
        }

        searchPlus(sum + 1, text + "1+");
        searchPlus(sum + 2, text + "2+");
        searchPlus(sum + 3, text + "3+");
    }
}