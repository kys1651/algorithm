import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count;
    static int[][] map;
    static boolean[][] visit;

    static int[] dirX = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dirY = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        // Input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // Input End

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                queue.add(new int[]{i, j});
                bfs(queue, map[i][j]);
            }
        }
        System.out.println(count);
    }

    private static void bfs(Queue<int[]> queue, int top) {
        boolean isTop = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (isIn(nX, nY)) {
                    if (map[nX][nY] > top) {
                        isTop = false;
                    } else if (!visit[nX][nY] && map[nX][nY] == top) {
                        visit[nX][nY] = true;
                        queue.offer(new int[]{nX, nY});
                    }
                }
            }
        }

        if(isTop) count++;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}