import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point{
        int x, y, k;
        int count;

        public Point(int x, int y, int k, int count) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.count = count;
        }
    }
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;
    static int answer = Integer.MAX_VALUE;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                int n = line.charAt(j) - '0';
                map[i][j] = n;
            }
        }

        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? "-1" : answer);
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, K, 1));

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                answer = Math.min(answer, p.count);
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(!isCheck(nx,ny) || visited[nx][ny][p.k]) continue;

                if (map[nx][ny] == 1) { // 벽일 때

                    if(p.k > 0 && !visited[nx][ny][p.k - 1]) { // 벽 부실 수 있고 방문 안했을 때
                        if (p.count % 2 == 0) { // 밤일 때
//                            System.out.println(nx + " " + ny + " " + p.k + " " + p.count);
                            q.add(new Point(p.x, p.y, p.k, p.count + 1));
                        } else { // 낮일 때
                            q.add(new Point(nx, ny, p.k - 1, p.count + 1));
                            visited[nx][ny][p.k - 1] = true;
                        }
                    }
                } else { // 벽이 아닐 때
                    visited[nx][ny][p.k] = true;
                    q.add(new Point(nx, ny, p.k, p.count + 1));
                }
            }
        }
    }

    private static boolean isCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
