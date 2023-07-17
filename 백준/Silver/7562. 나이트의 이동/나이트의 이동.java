import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static boolean[][] visited;
    // 8가지 나이트가 갈 수 있는 상황
    static int[][] dxy = {{-2, 1}, {-1, 2}, {-2, -1}, {-1, -2}, {1, 2}, {2, 1}, {1, -2}, {2, -1}};
    static Point start, end;

    // 좌표 저장 클래스
    static class Point{
        int x,y,count;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            L = Integer.parseInt(br.readLine());
            visited = new boolean[L][L];

            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs(start);
        }
    }

    private static void bfs(Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        visited[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            int nightX = tmp.x;
            int nightY = tmp.y;
            int count = tmp.count;

            // 조건 만족 할 때
            if (nightX == end.x && nightY == end.y) {
                System.out.println(count);
                return;
            }

            // 나이트가 갈 수 있는 8가지 조건
            for (int i = 0; i < 8; i++) {
                int nextX = nightX + dxy[i][0];
                int nextY = nightY + dxy[i][1];

                // 유효하지 않은 범위이거나 이미 방문한 상황일 때
                if (!isChecked(nextX, nextY) || visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY, count + 1));
            }
        }
    }

    private static boolean isChecked(int x, int y) {
        return x >= 0 && x < L && y >= 0 && y < L;
    }
}
