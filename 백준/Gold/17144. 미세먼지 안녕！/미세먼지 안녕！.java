import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] map; // 배열 상태
    static int[] airCleanUp; // 위를 보는 에어컨
    static int[] airCleanDown; // 아래를 보는 에어컨
    static Queue<int[]> dustList = new LinkedList<>(); // 미세먼지 큐

    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        // Input
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (airCleanUp == null) {
                        airCleanUp = new int[]{i, j};
                    } else {
                        airCleanDown = new int[]{i, j};
                    }
                }
            }
        }// Input End

        while (T-- > 0) {
            dust();
            airClean();
        }

        // 마지막에 미세먼지를 Count
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    answer += map[i][j];
                }
            }
        }
        System.out.println(answer);
    }

    // 에어컨이 공기 작동 메서드
    private static void airClean() {
        rotate(airCleanUp[0], airCleanUp[1], true);
        rotate(airCleanDown[0], airCleanDown[1], false);
    }

    // 회전하도록 한다. 행 열
    private static void rotate(int x, int y, boolean up) {
        int dir = 0;
        int nX = x + dirX[dir];
        int nY = y + dirY[dir];
        int prev = 0;
        while (!(nX == x && nY == y)) {
            int tmp = map[nX][nY];
            map[nX][nY] = prev;
            prev = tmp;
            if (!isIn(nX + dirX[dir], nY + dirY[dir])) {
                if (up) {
                    dir = dir == 0 ? 3 : dir - 1;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
            nX = nX + dirX[dir];
            nY = nY + dirY[dir];
        }
    }

    // 미세먼지를 퍼뜨린다.
    private static void dust() {

        // 미세먼지 위치를 세어주고 저장한다.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    dustList.add(new int[]{i, j, map[i][j]});
                    map[i][j] = 0;
                }
            }
        }

        // 배열이 빌 때 까지 확인
        while (!dustList.isEmpty()) {
            int[] cur = dustList.poll();
            int minus = cur[2] / 5;
            int count = 0;

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];
                if (!isIn(nX, nY) || map[nX][nY] == -1) {
                    continue;
                }
                map[nX][nY] += minus;
                count++;
            }
            map[cur[0]][cur[1]] += cur[2] - (count * minus);
        }
    }

    // 배열이 내부에 있는지 확인
    private static boolean isIn(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}