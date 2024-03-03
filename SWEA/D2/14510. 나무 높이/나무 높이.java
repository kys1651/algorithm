import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }// Input End

            Arrays.sort(height);
            int odd = 0, even = 0, maxHeight = height[N - 1];
            for (int i = 0; i < N; i++) {
                if (height[i] == maxHeight) break;
                int grow = maxHeight - height[i];
                even += grow / 2;
                odd += grow % 2;
            }
            int answer = 0;

            int min = Math.min(odd, even);
            answer += min * 2;
            odd -= min;
            even -= min;

            int day = 0; // 총 남은 일 수
            // 홀수가 남는 경우
            if (odd > 0) {
                // 오늘 짝수면
                if ((answer + 1) % 2 == 0) {
                    answer += (odd * 2);
                } else {
                    answer += (odd * 2) - 1;
                }
            }
            // 짝수가 남는 경우
            else if (even > 0) {
                day = even * 2;
                answer += (day / 3) * 2;
                day %= 3;
                // 오늘 짝수라면
                if (day != 0) {
                    if ((answer + 1) % 2 == 0) {
                        if (day % 2 == 0) {
                            answer++;
                        } else {
                            answer += 2;
                        }
                    }
                    // 오늘 홀수면
                    else {
                        if (day % 2 == 0) {
                            answer += 2;
                        } else {
                            answer++;
                        }
                    }
                }
            }

            sb.append(String.format("#%d %d\n", tc, answer));
        }
        System.out.println(sb);
    }
}
