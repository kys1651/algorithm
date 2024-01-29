import java.util.*;
import java.io.*;

public class Main {
    static int n, k, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        searchPlus(0, "");
        System.out.println(-1);
    }

    static void searchPlus(int sum, String text) {
        if (sum == n) {
            count++;
            if (count == k) {
                System.out.println(text.substring(0, text.length() - 1));
                System.exit(0);
            }
        }
        if (sum + 1 <= n) {
            searchPlus(sum + 1, text + "1+");
        }
        if (sum + 2 <= n) {
            searchPlus(sum + 2, text + "2+");
        }
        if (sum + 3 <= n) {
            searchPlus(sum + 3, text + "3+");
        }
    }
}