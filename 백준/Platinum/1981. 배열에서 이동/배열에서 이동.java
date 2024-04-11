import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;

    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // Input
        map = new int[N][N];
        int max = 0, min = 200;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] < min) {
                    min = map[i][j];
                }
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        } // Input End

        int l = 0, h = max - min;
        while (l <= h) {
            int m = (l + h) >> 1;
            boolean can = false;

            for (int i = min; i + m <= max; i++) {
                int s = i;
                int e = i + m;
                if (s <= map[0][0] && map[0][0] <= e) {
                    if (bfs(s, e)) {
                        can = true;
                        break;
                    }
                }
            }
            if (can) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(h + 1);
    }

    private static boolean bfs(int s, int e) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        boolean[][] visit = new boolean[N][N];
        visit[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == N - 1 && cur[1] == N - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (!isIn(nX, nY) || visit[nX][nY] || map[nX][nY] < s || map[nX][nY] > e) {
                    continue;
                }
                visit[nX][nY] = true;
                queue.add(new int[]{nX, nY});
            }
        }
        return false;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
