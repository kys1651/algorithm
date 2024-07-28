import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    private static int N, min, minCount;
    private static int[] cows;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int c = Math.abs(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));

            // Cow Input
            cows = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) cows[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(cows);
            // Cow Input End

            min = Integer.MAX_VALUE;
            minCount = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int horse = Integer.parseInt(st.nextToken());
                int idx = search(horse);
                // 보다 큰 값이 없는 경우
                if (idx == -1) {
                    setMinCount(horse, N - 1);
                }
                if (0 <= idx && idx < N) {
                    setMinCount(horse, idx);
                    if (idx != 0) {
                        setMinCount(horse, idx - 1);
                    }
                }
            }
            sb.append('#').append(tc).append(' ').append(min + c).append(' ').append(minCount).append('\n');
        }
        System.out.print(sb);
    }

    private static void setMinCount(int horse, int idx) {
        int m = Math.abs(horse - cows[idx]);
        if (m < min) {
            min = m;
            minCount = 1;
        } else if (m == min) {
            minCount++;
        }
    }

    private static int search(int value) {
        // value보다 같거나 큰 값 중 가장 왼쪽에 있는 값 찾기
        int left = 0, right = N - 1, idx = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (cows[mid] < value) {
                left = mid + 1;
            } else {
                idx = mid;
                right = mid - 1;
            }
        }
        return idx;
    }
}