import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    static class Core {
        int x;
        int y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Core> coreList;
    static int[][] map;
    static int N, K, coreCount, wireDist;

    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            coreList = new ArrayList<>();

            // Input
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    int tmp = input.charAt(j * 2) - '0';
                    // 벽에 붙어있지 않은 코어 위치 기억
                    if (tmp == 1) {
                        map[i][j] = 1;
                        if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                            continue;
                        }
                        coreList.add(new Core(i, j));
                    }
                }
            } // Input End

            coreCount = 0;
            wireDist = 144;
            K = coreList.size();

            permutation(0, 0, 0);

            sb.append(String.format("#%d %d\n", tc, wireDist));
        }

        System.out.println(sb);
    }

    private static void permutation(int depth, int count, int dist) {
        if (depth == K) {
            if (count > coreCount) {
                coreCount = count;
                wireDist = dist;
            } else if (count == coreCount) {
                if (wireDist > dist) {
                    wireDist = dist;
                }
            }
            return;
        }

        Core c = coreList.get(depth);
        for (int d = 0; d < 4; d++) {
            if (isLink(c, d)) {
                int tmpDist = fill(c, d, 1);
                permutation(depth + 1, count + 1, dist + tmpDist);
                fill(c, d, 0);
            }
        }
        permutation(depth + 1, count, dist);
    }

    private static int fill(Core c, int d, int value) {
        int tmp = 0;
        int x = c.x + dirX[d];
        int y = c.y + dirY[d];
        while (isIn(x, y)) {
            map[x][y] = value;
            tmp++;
            x += dirX[d];
            y += dirY[d];
        }
        return tmp;
    }

    private static boolean isLink(Core c, int d) {
        int x = c.x + dirX[d];
        int y = c.y + dirY[d];

        while (isIn(x, y)) {
            if (map[x][y] != 0) {
                return false;
            }
            x += dirX[d];
            y += dirY[d];
        }
        return true;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

