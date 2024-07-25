import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int[] days;
    static int n, p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            days = new int[n];

            // Input
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                days[i] = Integer.parseInt(st.nextToken());
            }// Input End
            sb.append('#').append(tc).append(' ').append(solve()).append('\n');
        }
        System.out.println(sb);
    }

    private static int solve() {
        int ans = 0;
        for (int i = 0; i < n; i++) {

            int left = i, right = n - 1, mid;
            while (left <= right) {
                mid = (left + right) >> 1;
                int blank = (days[mid] - days[i] + 1) - (mid - i + 1);
                if (blank > p) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                    ans = Math.max(ans, (days[mid] - days[i] + 1) + (p - blank));
                }
            }
        }
        return ans;
    }
}