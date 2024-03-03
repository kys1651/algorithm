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
            int answer = 0;
            int min = odd;
            if (odd > even) {
                min = even;
            }
            answer += min * 2;
            odd -= min;
            even = (even - min) * 2;
            answer += (even / 3) * 2;
            even %= 3;

            // 홀수가 남는 경우
            if (odd > 0) {
                answer += (odd * 2);
                // 홀수라면
                if ((answer + 1) % 2 != 0) {
                    answer--;
                }
            }
            // 짝수가 남는 경우
            else if (even > 0) {
                // 오늘 짝수라면
                if ((answer + 1) % 2 == 0) {
                    if (even % 2 == 0) {
                        answer++;
                    } else {
                        answer += 2;
                    }
                }
                // 오늘 홀수면
                else {
                    if (even % 2 == 0) {
                        answer += 2;
                    } else {
                        answer++;
                    }
                }
            }
            sb.append(String.format("#%d %d\n", tc, answer));
        }
        System.out.println(sb);
    }
}
