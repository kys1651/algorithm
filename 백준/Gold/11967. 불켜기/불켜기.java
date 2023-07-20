import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static boolean[][] lighted;
    static ArrayList<Point> [][] list;
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        lighted = new boolean[N][M];

        list = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            list[x][y].add(new Point(a, b));
        }

        System.out.println(bfs() + 1);
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        int count = 0;
        lighted[0][0] = true;
        visited[0][0] = true;

        boolean flag = false;
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (Point tmp : list[p.x][p.y]) {
                if (!lighted[tmp.x][tmp.y]) {
                    lighted[tmp.x][tmp.y] = true;
                    flag = true;
                    count++;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(!isCheck(nx,ny) || visited[nx][ny] || !lighted[nx][ny]) continue;

                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }

        if(flag){
            count += bfs();
        }
        return count;
    }

    private static boolean isCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
