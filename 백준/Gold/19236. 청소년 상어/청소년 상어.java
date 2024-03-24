import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dirY = {0, -1, -1, -1, 0, 1, 1, 1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[4][4];
        Pair[] fishes = new Pair[17];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;
                fishes[a] = new Pair(i, j, b);
                map[i][j] = a;
            }
        }

        int eat = map[0][0];
        Pair shark = new Pair(0, 0, fishes[eat].d);
        fishes[0] = new Pair(0, 0, -1); // 방금 먹은 물고기는 제거
        fishes[eat] = new Pair(0, 0, -1);
        map[0][0] = -1; // 상어 위치는 -1로 표현

        solve(map, fishes, eat, shark);
        System.out.println(result);
    }

    private static void solve(int[][] map, Pair[] fishes, int eat, Pair shark) {
        if(result < eat){
            result = eat;
        }

        int[][] nextMap = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nextMap[i][j] = map[i][j];
            }
        }

        Pair[] nextFishes = new Pair[17];
        for (int i = 1; i <= 16; i++) {
            nextFishes[i] = new Pair(fishes[i].x, fishes[i].y, fishes[i].d);
        }

        for (int i = 1; i <= 16; i++) {
            if (nextFishes[i].d == -1) continue;

            Pair f = new Pair(nextFishes[i].x, nextFishes[i].y, nextFishes[i].d);

            for (int d = 0; d < 8; d++) {
                int nd = (f.d + d) % 8;

                int nX = f.x + dirX[nd];
                int nY = f.y + dirY[nd];

                // 상어거나 배열 범위 밖이면 넘어간다.
                if (!isIn(nX, nY) || map[nX][nY] == -1) {
                    continue;
                }

                if(nextMap[nX][nY]==0) {
                    nextMap[f.x][f.y] = 0;
                }
                else if(nextMap[nX][nY]>0){
                    nextMap[f.x][f.y] = nextMap[nX][nY];
                    nextFishes[nextMap[nX][nY]] = new Pair(f.x, f.y, nextFishes[nextMap[nX][nY]].d);
                }
                nextMap[nX][nY] = i;
                nextFishes[i] = new Pair(nX, nY, nd);
                break;
            }
        }

        for (int i = 1; i <= 4; i++) {
            int nX = shark.x + i * dirX[shark.d];
            int nY = shark.y + i * dirY[shark.d];

            if (!isIn(nX, nY)) {
                break;
            }

            int idx = nextMap[nX][nY];
            if (idx <= 0) {
                continue;
            }

            nextMap[shark.x][shark.y] = 0;
            Pair s = new Pair(nX, nY, nextFishes[idx].d);
            nextFishes[idx] = new Pair(0, 0, -1);
            nextMap[nX][nY] = -1;

            solve(nextMap, nextFishes, eat+idx, s);

            nextMap[nX][nY] = idx;
            nextFishes[idx] = new Pair(nX, nY, s.d);
            nextMap[shark.x][shark.y] = -1;
        }

    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }

    static class Pair {
        int x;
        int y;
        int d;

        public Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}