import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static long[] b;
    static long[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());


        b = new long[n + 1];
        p = new long[n + 1];
        b[0] = 1;
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            b[i] = b[i - 1] * 2 + 3;
            p[i] = p[i - 1] * 2 + 1;
        }

        long answer = divide(n, k);
        System.out.println(answer);
    }

    private static long divide(int n, long k) {
        if (n == 0) {
            return 1;
        } else if (k == 1) {
            return 0;
        } else if (k == b[n]) {
            return p[n];
        }

        // 앞부분일 때
        if (k < b[n - 1] + 2) {
            return divide(n - 1, k - 1);
        } else if (k == b[n - 1] + 2) {
            return 1 + divide(n - 1, k - 2);
        } else {
            return p[n - 1] + 1 + divide(n - 1, k - (2 + b[n - 1]));
        }
    }
}
