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
    static int N, K, minDist, maxCount;

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

            maxCount = Integer.MIN_VALUE;
            minDist = Integer.MAX_VALUE;
            K = coreList.size();

            permutation(0, 0, 0);

            sb.append(String.format("#%d %d\n", tc, minDist));
        }

        System.out.println(sb);
    }

    private static void permutation(int depth, int count, int sum) {
        if (depth == K) {
            if (count > maxCount) {
                maxCount = count;
                minDist = sum;
            } else if (count == maxCount) {
                minDist = Math.min(minDist, sum);
            }
            return;
        }

        Core c = coreList.get(depth);
        for (int d = 0; d < 4; d++) {
            int nX = c.x;
            int nY = c.y;
            int dist = 0;

            while (true) {
                nX += dirX[d];
                nY += dirY[d];

                if (!isIn(nX, nY)) {
                    break;
                }

                // 전선을 만나면 안됨
                if (map[nX][nY] == 1) {
                    dist = 0;
                    break;
                }
                dist++;
            }

            if (dist == 0) {
                permutation(depth + 1, count, sum);
                continue;
            } else {

                nX = c.x;
                nY = c.y;
                for (int j = 0; j < dist; j++) {
                    nX += dirX[d];
                    nY += dirY[d];
                    map[nX][nY] = 1;
                }
                permutation(depth + 1, count + 1, sum + dist);
                nX = c.x;
                nY = c.y;
                for (int j = 0; j < dist; j++) {
                    nX += dirX[d];
                    nY += dirY[d];
                    map[nX][nY] = 0;
                }
            }


        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

