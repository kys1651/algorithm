import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int x;
        int y;

        int crush;

        public Point(int x, int y, int crush) {
            this.x = x;
            this.y = y;
            this.crush = crush;
        }

        @Override
        public int compareTo(Point o) {
            return crush - o.crush;
        }
    }

    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();

    }

    private static void bfs() {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                System.out.println(p.crush);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (!isCheck(nx, ny) || visited[nx][ny]) continue;

                // 벽일 경우 부수고 감
                if (map[nx][ny] == 1) {
                    q.add(new Point(nx, ny, p.crush + 1));
                } else { // 벽이 아닐 경우 그냥 감
                    q.add(new Point(nx, ny, p.crush));
                }
                visited[nx][ny] = true;
            }
        }

        System.out.println("0");

    }

    private static boolean isCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
