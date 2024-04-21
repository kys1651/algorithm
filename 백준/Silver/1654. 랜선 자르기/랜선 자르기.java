import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //Input
        long r = 0, l = 1;
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (r < arr[i]) r = arr[i];
        }// Input End

        r++;
        while (l <= r) {
            long m = (l + r) >> 1;
            // 자를 수 있으면 길이를 더 길게 자름
            if (isCan(m)) {
                l = m + 1;
            }
            // 못자르면 줄인다.
            else {
                r = m - 1;
            }
        }
        System.out.println(l - 1);
    }

    private static boolean isCan(long value) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            count += arr[i] / value;
            if (count >= K) return true;
        }
        return false;
    }
}
