import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Monkey{
        int x,y;
        int jump;
        int count;

        public Monkey(int x, int y, int jump, int count) {
            this.x = x;
            this.y = y;
            this.jump = jump;
            this.count = count;
        }
    }
    static int K,H,W;
    static int[][] map;
    static boolean[][][] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    map[i][j] = -1;
                }
            }
        }
        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? "-1" : answer);
    }

    private static void bfs() {
        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(0, 0, K, 0));

        // 말의 움직임
        int[][] night = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            Monkey m = q.poll();
            if (m.x == H - 1 && m.y == W - 1) {
                answer = Math.min(answer, m.count);
            }

            if(m.jump > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = m.x + night[i][0];
                    int ny = m.y + night[i][1];

                    // 범위가 아니거나 점프 횟수가 없을 때 그 곳이 장애물일 때
                    if (!isCheck(nx, ny) || map[nx][ny] == -1 || visited[nx][ny][m.jump - 1]) continue;
                    visited[nx][ny][m.jump - 1] = true;
                    q.add(new Monkey(nx, ny, m.jump - 1, m.count + 1));
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = m.x + dx[i];
                int ny = m.y + dy[i];

                if(!isCheck(nx,ny) || map[nx][ny] == -1 || visited[nx][ny][m.jump]) continue;

                visited[nx][ny][m.jump] = true;
                q.add(new Monkey(nx, ny, m.jump, m.count+1));
            }
        }
    }

    private static boolean isCheck(int x, int y) {
        return x >= 0 && y >= 0 && x < H && y < W;
    }
}
