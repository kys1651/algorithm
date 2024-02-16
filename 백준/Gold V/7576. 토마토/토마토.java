import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, day, empty;
    static int[][] map;
    static Queue<int[]> tomato = new LinkedList<>();

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    tomato.add(new int[]{i, j});
                } else if (map[i][j] == 0) {
                    empty++;
                }
            }
        }

        bfs();
        System.out.println(day - 1);
    }

    private static void bfs() {
        while (!tomato.isEmpty()) {
            int count = tomato.size();
            day++;

            for (int c = 0; c < count; c++) {
                int[] cur = tomato.poll();

                for (int i = 0; i < 4; i++) {
                    int nX = cur[0] + dirX[i];
                    int nY = cur[1] + dirY[i];

                    if (nX < 0 || nX >= N || nY < 0 || nY >= M || map[nX][nY] != 0) {
                        continue;
                    }
                    map[nX][nY] = 1;
                    tomato.add(new int[]{nX, nY});
                    empty--;
                }
            }
        }
        if (empty != 0) {
            day = 0;
        }
    }
}