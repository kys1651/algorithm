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

        System.out.println(divide(n, k));
    }

    private static long divide(int n, long k) {
        // n이 0이면 1
        if (n == 0) {
            return 1;
        }
        // k가 1보다 적거나 같으면 번
        else if (k <= 1) {
            return 0;
        }

        // 중간지점
        long mid = b[n - 1] + 2;
        // 중간지점보다 적은 곳(빵 개수 -1)
        if (k < mid) {
            return divide(n - 1, k - 1);
        }
        // 가운데 지점인 경우 가운데 패티(1) + 이전지점
        else if (k == mid) {
            return 1 + p[n - 1];
        }
        // 그보다 큰 경우 가운데 패티(1) + 이전지점 + 현재 지점
        else {
            return p[n - 1] + 1 + divide(n - 1, k - mid);
        }
    }
}
