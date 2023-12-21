import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Tomato {
        int x;
        int y;
        int h;

        public Tomato(int h, int x, int y) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    static int n, m, h;
    static int[][][] map;
    static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < map[i][j].length; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        queue.offer(new Tomato(i, j, k));
                    }
                }
            }
        }
        bfs();
        int result = 0;
        loop:
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                for (int k = 0; k < map[i][j].length; k++) {
                    if (map[i][j][k] == 0) {
                        result = 0;
                        break loop;
                    } else {
                        result = Math.max(result, map[i][j][k]);
                    }
                }
            }
        }
        System.out.println(result - 1);
    }

    private static void bfs() {
        int[] dirH = {0, 0, 0, 0, -1, 1};
        int[] dirX = {1, -1, 0, 0, 0, 0};
        int[] dirY = {0, 0, -1, 1, 0, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                Tomato curTomato = queue.poll();

                for (int d = 0; d < 6; d++) {
                    int nextH = curTomato.h + dirH[d];
                    int nextX = curTomato.x + dirX[d];
                    int nextY = curTomato.y + dirY[d];

                    // 상자의 크기를 벗어나는 경우
                    if (check(nextH, nextX, nextY)) {
                        continue;
                    }

                    // 다음 좌표가 익지않는 토마토인 경우
                    if (map[nextH][nextX][nextY] == 0) {
                        map[nextH][nextX][nextY] = map[curTomato.h][curTomato.x][curTomato.y] + 1;
                        queue.offer(new Tomato(nextH, nextX, nextY));
                    }
                }

            }
        }
    }

    private static boolean check(int nZ, int nX, int nY) {
        return nZ < 0 || nZ >= map.length || nX < 0 || nX >= map[nZ].length || nY < 0 || nY >= map[nZ][nX].length;
    }
}