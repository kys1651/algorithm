import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int n, m;
    static int[][] map;
    static boolean[][][] visit;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visit = new boolean[2][n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }
        if (n == 1 && m == 1) {
            System.out.println(1);
            System.exit(0);
        }
        bfs();
    }

    private static void bfs() {
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(1, 1, 0));

        while (!queue.isEmpty()) {
            Point pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dirX[i];
                int ny = pos.y + dirY[i];

                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    continue;
                }
                // 벽인 경우
                if (map[nx][ny] == 1) {
                    // 1. 벽을 부순적 있는가? count가 0이면 부순적 없음
                    // 2. 방문한 적 있는가? visit[1][nx][ny]가 false면 방문한 적 없음
                    if(pos.count == 0 && !visit[1][nx][ny]){
                        visit[0][nx][ny] = true; // 방문
                        map[nx][ny] = map[pos.x][pos.y] + 1; // 현재 거리에서 + 1
                        queue.offer(new Point(nx, ny, 1)); // 다음 위치를 넣어줌
                    }

                }
                // 벽이 아닌 경우
                else {
                    if (!visit[pos.count][nx][ny]) {
                        visit[pos.count][nx][ny] = true;
                        map[nx][ny] = map[pos.x][pos.y] + 1;
                        queue.offer(new Point(nx, ny, pos.count));
                    }
                    if (nx == n && ny == m) {
                        System.out.println(map[n][m] + 1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(-1);
    }
}