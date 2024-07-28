import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static long[] candy;
    private static long n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Long.parseLong(st.nextToken());
            m = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());

            candy = new long[(int) n];
            long right = 1;
            for (int i = 0; i < n; i++) {
                candy[i] = Long.parseLong(st.nextToken());
                right = Math.max(right, candy[i]);
            }

            long left = 1, answer = 0;
            while (left <= right) {
                long mid = (left + right) / 2;
                if (check(mid)) {
                    answer = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean check(long value) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += candy[i] / value;
        }
        return count >= m;
    }
}