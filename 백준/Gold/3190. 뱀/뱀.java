import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 보드의 크기
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        // 사과의 개수
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            // 사과는 2로 저장한다.
            board[r][c] = 2;
        }

        // 뱀의 방향 변환 정보
        int L = Integer.parseInt(br.readLine());
        char[] command = new char[100001];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            command[t] = c;
        }

        // 뱀이 위차한 곳의 정보 뱀은 0,0에서 시작한다.
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        board[0][0] = 1;
        int x = 0, y = 0;

        // 오른쪽 -> 아래 -> 왼쪽 -> 위
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        int d = 0; // 현재 방향을 보는 d

        // 흘러가는 시간
        int time = 0;
        while (true) {
            time++;
//            System.out.println(time + ": " + x + "," + y);
            x += dirX[d];
            y += dirY[d];

            // 다음 방향이 벽이거나 뱀의 몸이라면 현재 시간 출력 후 종료
            if (x < 0 || x >= N || y < 0 || y >= N || board[x][y] == 1) {
                System.out.println(time);
                return;
            }

            // 다음 위치가 사과가 아니라면 몸은 줄어든다.
            if (board[x][y] != 2) {
                int[] tail = queue.poll();
                board[tail[0]][tail[1]] = 0;
            }

            // 다음 위치에 몸이 있는 것으로 기억함
            board[x][y] = 1;
            queue.add(new int[]{x, y});

            // 현재 시간이 방향 전환 할 시간이라면
            if (command[time] == 'D') {
                d++;
                if (d == 4) d = 0;
            } else if (command[time] == 'L') {
                d--;
                if (d == -1) d = 3;
            }
        }
    }
}
