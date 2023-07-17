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

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Point> Fire,Person;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int w, h;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visited = new boolean[h][w];

            Fire = new LinkedList<>();
            Person = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    char ch = line.charAt(j);
                    map[i][j] = 0;

                    if(ch == '#'){
                        map[i][j] = -1;
                    } else if (ch == '*') {
                        map[i][j] = -1;
                        visited[i][j] = true;
                        Fire.add(new Point(i, j));
                    } else if(ch == '@'){
                        map[i][j] = 1;
                        Person.add(new Point(i, j));
                    }
                }
            }
            bfs();
        }
    }

    private static void bfs() {
        // 불 -> 상근이 순서로 해야함
        while (!Person.isEmpty()) {
            int fireLen = Fire.size();
            int personLen = Person.size();

            // 불 먼저 한번
            for (int i = 0; i < fireLen; i++) {
                Point f = Fire.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = f.x + dx[d];
                    int ny = f.y + dy[d];

                    // 유효한 범위가 아니거나 방문 했으면 Skip
                    if (!isCheck(nx, ny) || visited[nx][ny]) continue;

                    // 벽이라면 Skip
                    if(map[nx][ny] == -1) continue;

                    visited[nx][ny] = true;
                    Fire.add(new Point(nx, ny));
                }
            }

            // 상근이 차례
            for (int i = 0; i < personLen; i++) {
                Point p = Person.poll();


                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    // 유효범위 밖이면 탈출한거임
                    if(!isCheck(nx,ny)){
                        System.out.println(map[p.x][p.y]);
                        return;
                    }

                    // 벽이거나 불이면 skip
                    // 0이 아니라는건 -> 벽이거나 불이거나 방문했다는 것
                    if(map[nx][ny] == 0 && !visited[nx][ny]) {
                        map[nx][ny] = map[p.x][p.y] + 1;
                        Person.add(new Point(nx, ny));
                    }
                }
            }
        }
        // 큐가 끝나고 나왔다는건 갈 수 없다는 뜻
        System.out.println("IMPOSSIBLE");
    }

    private static boolean isCheck(int x, int y) {
        return x >= 0 && h > x && y >= 0 && y < w;
    }
}
