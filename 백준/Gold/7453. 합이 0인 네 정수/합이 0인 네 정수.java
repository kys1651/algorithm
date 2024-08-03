import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        long[] b = new long[n];
        long[] c = new long[n];
        long[] d = new long[n];
        // Input
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Long.parseLong(st.nextToken());
            b[i] = Long.parseLong(st.nextToken());
            c[i] = Long.parseLong(st.nextToken());
            d[i] = Long.parseLong(st.nextToken());
        }// Input End

        long[] ab = new long[n * n];
        long[] cd = new long[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[idx] = a[i] + b[j];
                cd[idx++] = c[i] + d[j];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        System.out.println(solve(ab, cd, n));
    }

    private static long solve(long[] ab, long[] cd, int n) {
        long answer = 0;

        int l = 0, r = n * n - 1;
        while (l < n * n && r >= 0) {
            long sum = ab[l] + cd[r];

            if (sum < 0) {
                l++;
                continue;
            } else if (sum > 0) {
                r--;
                continue;
            }

            long lCount = 1;
            l++;
            while (l < n * n && ab[l] == ab[l - 1]) {
                lCount++;
                l++;
            }

            long rCount = 1;
            r--;
            while (r >= 0 && cd[r] == cd[r + 1]) {
                rCount++;
                r--;
            }
            answer += lCount * rCount;
        }
        return answer;
    }


}