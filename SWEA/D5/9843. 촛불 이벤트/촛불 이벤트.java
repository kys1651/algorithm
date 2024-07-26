import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static final long MAX = 10000000000L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine());
            sb.append('#').append(tc).append(' ').append(solve(N)).append('\n');
        }
        System.out.print(sb);
    }

    private static long solve(long n) {
        long left = 1, right = MAX, answer = -1;

        while (left <= right) {
            long mid = (left + right) >> 1;
            long v = (mid * (mid + 1)) >> 1;

            if (v == n) {
                answer = mid;
                break;
            } else if (v > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}