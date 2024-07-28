import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static int N, L;
    private static int[] s, e;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            L = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            s = new int[N];
            e = new int[N];

            // Input
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                s[i] = Integer.parseInt(st.nextToken());
                e[i] = Integer.parseInt(st.nextToken());
            }// Input End

            int answer = 0, left = 1, right = L;
            while (left <= right) {
                int mid = (left + right) / 2;

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

    private static boolean check(int target) {
        int left = 0, right = 0; // 왼쪽 포인터, 오른쪽 포인터
        int peakTime = 0, totalTime = 0; // 광고 시간, 전체 시간

        while (true) {
            // 목표 시간을 넘기는 경우
            if (peakTime + (e[right] - s[right]) >= target) {
                // 전체 시간이 L을 넘기지 않는다면
                if (totalTime + (target - peakTime) <= L) return true;
                else {
                    peakTime -= (e[left] - s[left]);
                    totalTime -= (s[left + 1] - s[left]);
                    left++;
                }
            } else {
                if (right == N - 1) break;
                peakTime += (e[right] - s[right]);
                totalTime += (s[right + 1] - s[right]);
                right++;
            }
        }
        return false;
    }
}