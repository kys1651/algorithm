import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] height = new int[N];

            // Input
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxHeight = 0;
            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
                if (maxHeight < height[i]) {
                    maxHeight = height[i];
                }
            }// Input End

            int odd = 0, even = 0;
            for (int i = 0; i < N; i++) {
                int grow = maxHeight - height[i];

                even += grow / 2;
                odd += grow % 2;
            }

            if (even > odd) {
                while (Math.abs(even - odd) > 1) {
                    even--;
                    odd += 2;
                }
            }
            int answer = 0;
            if (odd > even) {
                answer = (odd * 2) - 1;
            } else if (even > odd) {
                answer = even * 2;
            } else {
                answer = odd + even;
            }
            sb.append(String.format("#%d %d\n", tc, answer));
        }
        System.out.println(sb);
    }
}
