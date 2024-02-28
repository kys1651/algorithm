import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int[][] map;
    static boolean[][][] visit;

    static int[] dirX = {0, 1, 0, -1, 1, 2, -1, -2, 1, 2, -1, -2};
    static int[] dirY = {1, 0, -1, 0, 2, 1, 2, 1, -2, -1, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visit = new boolean[K + 1][H][W];
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j * 2) - '0';
            }
        }

        if (W == 1 && H == 1) {
            System.out.println(0);
            return;
        }

        bfs(K);
        System.out.println(-1);
    }

    private static void bfs(int K) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, K, 0});
        visit[K][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int jump = cur[2];

            for (int i = 0; i < 12; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (i == 4) {
                    if (jump == 0) {
                        break;
                    }
                    jump--;
                }
                // 배열 범위 밖이거나 || 벽이면 넘어간다.
                if (!isIn(nX, nY) || map[nX][nY] == 1 || visit[jump][nX][nY]) {
                    continue;
                }

                visit[jump][nX][nY] = true;
                queue.add(new int[]{nX, nY, jump, cur[3] + 1});

                if (nX == H - 1 && nY == W - 1) {
                    System.out.println(cur[3] + 1);
                    System.exit(0);
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}
