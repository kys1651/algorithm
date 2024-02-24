import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] map;
    static int[] airCleanUp;
    static int[] airCleanDown;
    static Queue<int[]> dustList = new LinkedList<>();

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
//            print();
            airClean();
//            print();
        }

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

    private static void airClean() {
        rotate(airCleanUp[0], airCleanUp[1], true);
        rotate(airCleanDown[0], airCleanDown[1], false);
    }

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

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void dust() {
        int[][] tmp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    dustList.add(new int[]{i, j});
                }
            }
        }

        while (!dustList.isEmpty()) {
            int[] cur = dustList.poll();
            int minus = map[cur[0]][cur[1]] / 5;
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];
                if (!isIn(nX, nY) || map[nX][nY] == -1) {
                    continue;
                }
                tmp[nX][nY] += minus;
                count++;
            }
            tmp[cur[0]][cur[1]] += map[cur[0]][cur[1]] - (count * minus);
        }

        tmp[airCleanUp[0]][airCleanUp[1]] = -1;
        tmp[airCleanDown[0]][airCleanDown[1]] = -1;
        map = tmp;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}