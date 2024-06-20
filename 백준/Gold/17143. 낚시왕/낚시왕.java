import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Shark {
        int idx;
        int x, y;
        int speed;
        int dir;
        int size;

        public Shark(int idx, int x, int y, int speed, int dir, int size) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

        private void move() {
            int totalSpeed = speed;
            while (true) {
                int dist = getDist();

                // 거리가 0이라면 벽을 보고 있는 상황 반대를 보게 함
                if (dist == 0) {
                    other();
                }
                // 현재 가야하는 거리보다 남아있는 거리가 더 긴 경우 보내주면 된다.
                else if (dist >= totalSpeed) {
                    x = x + dirX[dir] * totalSpeed;
                    y = y + dirY[dir] * totalSpeed;
                    break;
                } else {
                    totalSpeed -= dist;
                    x = x + dirX[dir] * dist;
                    y = y + dirY[dir] * dist;
                    other();
                }
            }
        }

        private int getDist() {
            switch (dir) {
                case 0: return x;
                case 1: return R - x - 1;
                case 2: return C - y - 1;
                default: return y;
            }
        }

        private void other() {
            switch (dir) {
                case 0: dir = 1;break;
                case 1: dir = 0;break;
                case 2: dir = 3;break;
                case 3: dir = 2;
            }
        }
    }

    static int R, C, M, answer, count;
    static int[][][] map;
    static boolean[] die;
    static Shark[] sharks;

    // 위, 아래, 오른쪽, 왼쪽
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = count = Integer.parseInt(st.nextToken());
        map = new int[2][R][C];
        die = new boolean[M + 1];
        sharks = new Shark[M + 1];

        // Input
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int size = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(i, x, y, speed, dir, size);

            map[0][x][y] = i;
        }// Input End

        for (int i = 0; i < C && count != 0; i++) {
            catchShark(i);
            sharkMove();
        }
        System.out.println(answer);
    }

    private static void sharkMove() {
        for (int i = 1; i <= M; i++) {
            Shark s = sharks[i];
            // 죽은 상어라면 넘어간다.
            if (die[s.idx]) {
                continue;
            }
            // 죽은 상어가 아니라면 이동해줌
            int curX = s.x;
            int curY = s.y;
            s.move();
            changeSharkPos(s, curX, curY);
        }
        int[][] tmp = map[1];
        map[1] = map[0];
        map[0] = tmp;
    }

    private static void changeSharkPos(Shark s, int x, int y) {
        map[0][x][y] = 0;
        int idx = map[1][s.x][s.y];
        if (idx == 0) {
            map[1][s.x][s.y] = s.idx;
            return;
        }

        count--;
        if (sharks[idx].size > s.size) {
            die[s.idx] = true;
        } else {
            die[idx] = true;
            map[1][s.x][s.y] = s.idx;
        }
    }

    private static void catchShark(int pos) {
        for (int i = 0; i < R; i++) {
            if (map[0][i][pos] != 0) {
                int idx = map[0][i][pos];
                die[idx] = true;
                answer += sharks[idx].size;
                map[0][i][pos] = 0;
                count--;
                return;
            }
        }
    }
}