import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            arr = new int[4][8];

            // Input
            for (int i = 0; i < 4; i++) {
                String input = br.readLine();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = input.charAt(j * 2) - '0';
                }
            }// Input End

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()); // 돌리는 배열
                int dir = Integer.parseInt(st.nextToken()); // 방향
                visit = new boolean[4]; // 방문 처리
                rotate(idx - 1, dir);
            }
            sb.append(String.format("#%d %d\n", tc, getResult()));
        }
        System.out.println(sb);
    }

    // 결과를 구해준다.
    private static int getResult() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (1 << i) * arr[i][0];
        }
        return sum;
    }

    private static void rotate(int idx, int dir) {
        visit[idx] = true;
        // [6]: 왼쪽 날, [2]: 오른쪽 날
        if (idx > 0) {
            // 왼쪽날과 왼쪽 톱니바퀴의 오른쪽 날이 다르다면 돌린다.
            if (arr[idx][6] != arr[idx - 1][2] && !visit[idx - 1]) {
                rotate(idx - 1, dir == 1 ? -1 : 1);
            }
        }
        if (idx < 3) {
            // 오른쪽 톱니바퀴의 왼쪽날과 현재 위치에 오른쪽날이 다르다면 돌린다.
            if (arr[idx][2] != arr[idx + 1][6] && !visit[idx + 1]) {
                rotate(idx + 1, dir == 1 ? -1 : 1);
            }
        }
        // 1이면 Clock Wise
        if (dir == 1) {
            CW(idx);
        }
        // 아니라면 Counter Clock Wise
        else {
            CCW(idx);
        }
    }

    // 시계 반대방향으로 돌려준다.
    private static void CCW(int idx) {
        int tmp = arr[idx][0];
        for (int i = 0; i <= 6; i++) {
            arr[idx][i] = arr[idx][i + 1];
        }
        arr[idx][7] = tmp;
    }

    // 시계 방향으로 배열을 돌린다.
    private static void CW(int idx) {
        int tmp = arr[idx][7];
        for (int i = 7; i >= 1; i--) {
            arr[idx][i] = arr[idx][i - 1];
        }
        arr[idx][0] = tmp;
    }
}
