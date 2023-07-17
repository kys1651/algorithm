import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point{
        int x, y,count;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.count = 0;
        }

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int[][] map ;
    static boolean[][] visited;
    static int N;
    static int idx = 1;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬에 값을 매겨줌
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] != 0){
                    bfs(i, j);
                    idx++;
                }
            }
        }

        // 섬을 이어준다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 1) {
                    visited = new boolean[N][N];
                    linkLand(i, j);
                }
            }
        }

        System.out.println(answer);
    }
    
    // 각 섬을 다른 섬과 이어준다. 기존 번호와 다른지 확인하여 판단함
    private static void linkLand(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));
        visited[x][y] = true;

        int currentNum = map[x][y];
        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(!isCheck(nx,ny) || visited[nx][ny] || map[nx][ny] == currentNum) continue;

                visited[nx][ny] = true;
                if (map[nx][ny] == 0) {
                    q.add(new Point(nx, ny, tmp.count + 1));
                }else{
                    answer = Math.min(answer, tmp.count);
                }
            }
        }
    }

    // bfs를 통해 섬에 숫자를 매겨줌
    private static void bfs(int x, int y) {
        visited[x][y] = true;
        map[x][y] = idx;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (!isCheck(nx, ny) || visited[nx][ny] || map[nx][ny] == 0) continue;

                map[nx][ny] = map[tmp.x][tmp.y];
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
    }
 
    // 범위인지 아닌지 판단
    private static boolean isCheck(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
