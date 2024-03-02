import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Shark {
        int idx;
        int x;
        int y;
        int speed;
        int d;
        int size;
        boolean die;

        public Shark(int idx, int x, int y, int speed, int d, int size) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.d = d;
            this.size = size;
        }

        public int getDist() {
            // 위를 보는 경우
            if (d == 0) {
                return x;
            } else if (d == 1) {
                return R - x - 1;
            } else if (d == 2) {
                return C - y - 1;
            } else {
                return y;
            }
        }

        public void otherDir() {
            if (d == 0) d = 1;
            else if (d == 1) d = 0;
            else if (d == 2) d = 3;
            else d = 2;
        }
    }

    static int R, C, M;
    static Shark[] sharks;
    static int[][][] map;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // Input
        sharks = new Shark[M + 1];
        map = new int[R][C][2];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(i, r, c, s, d, z);
            if (map[r][c][0] == 0) {
                map[r][c][0] = i;
            } else {
                int sIdx = map[r][c][0];
                if (sharks[sIdx].size > z) {
                    sharks[i].die = true;
                } else {
                    sharks[sIdx].die = true;
                    map[r][c][0] = i;
                }
            }
        }// Input End

        int answer = 0;
        for (int i = 0; i < C; i++) {
            answer += sharkCatch(i);
            moveShark();
        }

        System.out.println(answer);
    }

    private static void moveShark() {
        for (int i = 1; i <= M; i++) {
            Shark s = sharks[i];

            // 잡힌 상어라면 처리 X
            if (s.die) {
                continue;
            }

            int speed = s.speed;
            if (s.d == 0 || s.d == 1) {
                speed = speed % (2 * (R - 1));
            } else {
                speed = speed % (2 * (C - 1));
            }

            // 기존 위치 저장
            int x = s.x;
            int y = s.y;
            while (true) {
                int dist = s.getDist();

                // 벽에 붙어있는 경우 그냥 돌아보게만 한다.
                if (dist == 0) {
                    s.otherDir();
                }
                // 거리가 그 안에 해결 된다면 보내준다.
                else if (dist >= speed) {
                    s.x = s.x + dirX[s.d] * speed;
                    s.y = s.y + dirY[s.d] * speed;
                    break;
                }
                // 거리가 남는다면 벽에 붙히고 나머지 계산
                else {
                    speed -= dist;
                    s.x = s.x + dirX[s.d] * dist;
                    s.y = s.y + dirY[s.d] * dist;
                    s.otherDir();
                }
            }
            posShark(s, x, y);
        }

        for (int i = 1; i <= M; i++) {
            Shark s = sharks[i];
            if (s.die) continue;
            if (map[s.x][s.y][0] != s.idx) {
                map[s.x][s.y][0] = s.idx;
                map[s.x][s.y][1] = 0;
            }
        }
    }

    private static void posShark(Shark s, int x, int y) {
        // 기존 위치에서 상어 지워준다.
        map[x][y][0] = 0;
        if (map[s.x][s.y][1] == 0) {
            map[s.x][s.y][1] = s.idx;
        } else if (map[s.x][s.y][1] != 0) {
            int sIdx = map[s.x][s.y][1];
            Shark originShark = sharks[sIdx];
            if (originShark.size > s.size) {
                s.die = true;
            } else {
                map[s.x][s.y][1] = s.idx;
                originShark.die = true;
            }
        }
    }

    private static int sharkCatch(int pos) {
        // 가장 가까운 상어를 받아온다.
        for (int i = 0; i < R; i++) {
            if (map[i][pos][0] == 0) {
                continue;
            }
            Shark s = sharks[map[i][pos][0]];
            map[i][pos][0] = 0;
            s.die = true;
            return s.size;
        }

        return 0;
    }
}
