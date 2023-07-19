import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N,M,P;
    static Queue<Point>[] qs;
    static int[][] map;
    static int[] distance;
    static int[] castle;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        qs = new Queue[P + 1];
        castle = new int[P + 1];
        distance = new int[P + 1];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            qs[i] = new LinkedList<>();
            distance[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = line.charAt(j);
                if (ch == '.') {
                    map[i][j] = 0;
                }else if(ch == '#'){
                    map[i][j] = -1;
                }else{
                    int tmp = ch - '0';
                    map[i][j] = tmp;
                    castle[tmp]++;
                    qs[tmp].add(new Point(i, j));
                }
            }
        }

        int player = 1;
        int round = 0;
        while (true) {
            int maxDist = distance[player];
            int count = bfs(qs[player], maxDist, player);

            castle[player] += count;
            round += count;
            player++;

            if (player > P) {
                if(round == 0) break;
                round = 0;
                player = 1;
            }
        }

        for (int i = 1; i <= P; i++) {
            System.out.print(castle[i] + " ");
        }
    }

    private static int bfs(Queue<Point> q, int maxDist, int player) {
        int count = 0;
        int dist = 1;

        while (!q.isEmpty()) {
                int len = q.size();

                for (int i = 0; i < len; i++) {
                    Point tmp = q.poll();

                    // distance만큼 상하좌우로 갈 수 있다.
                    for (int d = 0; d < 4; d++) {
                        int nx = tmp.x + dx[d];
                        int ny = tmp.y + dy[d];

                        // 이미 방문했거나 범위밖이면 out
                        if (!isCheck(nx, ny) || map[nx][ny] != 0) {
                            continue;
                        }

                        q.add(new Point(nx, ny));
                        map[nx][ny] = player;
                        count++;
                    }
                }
                dist++;
            if (dist > maxDist)
                break;
        }
        return count;
    }

    private static boolean isCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
