import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int INF = 1000_000_000;

    static int N;
    static int[][] map, visit;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            // Input
            map = new int[N][N];
            visit = new int[N][N];
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = input.charAt(j * 2) - '0';
                    visit[i][j] = INF;
                }
            }// Input End

            bfs();
            sb.append(String.format("Problem %d: %d\n", tc++, visit[N - 1][N - 1]));
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];
                // 배열 범위 밖이라면 넘어간다.
                if (!isIn(nX, nY)) {
                    continue;
                }

                // 첫 방문이거나 더 싸게 갈 수 있는 비용이라면 갱신 후 큐에 삽입
                if (visit[nX][nY] > visit[cur[0]][cur[1]] + map[nX][nY]) {
                    visit[nX][nY] = visit[cur[0]][cur[1]] + map[nX][nY];
                    queue.add(new int[]{nX, nY});
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
