import java.util.*;
import java.io.*;

public class Main {
    static class Player {
        Player up, down;
        int x, y, d, idx;

        public Player(int x, int y, int d, int idx) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.idx = idx;
        }

        public void changeDir() {
            switch (d) {
                case 0:
                    d = 1;
                    break;
                case 1:
                    d = 0;
                    break;
                case 2:
                    d = 3;
                    break;
                default:
                    d = 2;
                    break;
            }
        }

        public void move(int x, int y) {
            this.x = x;
            this.y = y;
            if (up != null) {
                up.move(x, y);
            }
        }

        public Player getTop() {
            if (up == null) {
                return this;
            } else {
                return up.getTop();
            }
        }

        public int getCount() {
            int count = 1;
            if (up != null) {
                count += up.getCount();
            }
            return count;
        }

        public void swap() {
            if (up != null) {
                up.swap();
            }
            Player tmp = up;
            up = down;
            down = tmp;
        }
    }

    static int N, K;
    static int[][] map;
    static int[][] pos;
    static Player[] players;

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // Map Input
        map = new int[N][N];
        pos = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j * 2) - '0';
                pos[i][j] = -1;
            }
        } // Map Input End

        // Player Input
        players = new Player[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            players[i] = new Player(x, y, d, i);
            pos[x][y] = i;
        } // Player Input End

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        int count = 0;
        while (count < 1000) {
            count++;

            for (int i = 0; i < K; i++) {
                Player p = players[i];
                int nX = p.x + dirX[p.d];
                int nY = p.y + dirY[p.d];

                // 체스판을 벗어나거나 파란색을 만나는 경우
                if (!isIn(nX, nY) || map[nX][nY] == 2) {
                    p.changeDir();
                    nX = p.x + dirX[p.d];
                    nY = p.y + dirY[p.d];
                    if (!isIn(nX, nY) || map[nX][nY] == 2) {
                        continue;
                    }
                }

                if (pos[p.x][p.y] == i) {
                    pos[p.x][p.y] = -1;
                }else{
                    p.down.up = null;
                    p.down = null;
                }
                // 빈 공간
                int nextIdx = pos[nX][nY];
                if (map[nX][nY] == 0) {
                    p.move(nX, nY);
                    // 아무것도 없다면
                    if (nextIdx == -1) {
                        pos[nX][nY] = i;
                        if (p.down != null) {
                            p.down.up = null;
                            p.down = null;
                        }

                    } else {
                        Player nextTop = players[nextIdx].getTop();
                        nextTop.up = p;
                        p.down = nextTop;
                        if (players[nextIdx].getCount() >= 4) {
                            return count;
                        }
                    }
                }
                // 빨간 공간이면 현재 말을 뒤집어주고 추가
                else {
                    if(p.down != null){
                        p.down.up = null;
                        p.down = null;
                    }
                    Player curTop = p.getTop();
                    p.swap();

                    curTop.move(nX, nY);
                    if (nextIdx == -1) {
                        pos[nX][nY] = curTop.idx;
                    } else {
                        Player nextTop = players[nextIdx].getTop();
                        nextTop.up = curTop;
                        curTop.down = nextTop;
                        if (players[nextIdx].getCount() >= 4) {
                            return count;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static void print() {
        for (int i = 0; i < K; i++) {
            Player p = players[i];
            System.out.println(i + 1 + ": " + p.x + ", " + p.y + " d : " + p.d);
        }
        System.out.println();
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

