import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos{
        int x,y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N,M;
    static char [][] map;
    static Queue<Pos> JQueue = new LinkedList<>();
    static Queue<Pos> FQueue = new LinkedList<>();
    static boolean[][] JVisited;
    static boolean[][] FVisited;

    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        JVisited = new boolean[N][M];
        FVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);

                if(map[i][j] == 'J'){
//                    map[i][j] = '.'; // 이유는 일단 x
                    JQueue.add(new Pos(i, j));
                    JVisited[i][j] = true;
                }
                if (map[i][j] == 'F') {
                    FQueue.add(new Pos(i, j));
                    FVisited[i][j] = true;
                }
            }
        }

        bfs();
        System.out.println("IMPOSSIBLE");
    }

    private static void bfs() {
        int time = 0;

        while (!JQueue.isEmpty()) {
            int JLen = JQueue.size();
            int FLen = FQueue.size();

            // 불 먼저 확인하기
            for (int i = 0; i < FLen; i++) {
                Pos fire = FQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = fire.x + dx[d];
                    int ny = fire.y + dy[d];

                    if(!IsIn(nx,ny) || map[nx][ny] == '#' || FVisited[nx][ny]) continue;

                    FVisited[nx][ny] = true;
                    map[nx][ny] = 'F';
                    FQueue.add(new Pos(nx, ny));
                }
            }

            for (int i = 0; i < JLen; i++) {
                Pos jihun = JQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = jihun.x + dx[d];
                    int ny = jihun.y + dy[d];

                    if (!IsIn(nx, ny)) {
                        time++;
                        System.out.println(time);
                        System.exit(0);
                    }

                    if(map[nx][ny] != '.' || JVisited[nx][ny]) continue;
                    JVisited[nx][ny] = true;
                    JQueue.add(new Pos(nx, ny));
                }
            }

            time++;
        }
    }

    // 범위내에 갈 수 있는지
    private static boolean IsIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

}
