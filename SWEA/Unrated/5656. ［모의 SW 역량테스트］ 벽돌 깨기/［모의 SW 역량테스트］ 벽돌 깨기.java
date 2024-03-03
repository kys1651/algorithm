import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N, W, H, result;
    static int[][] map;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            result = W * H; // 최대값은 모든 벽돌이 차있는 경우
            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = input.charAt(j * 2) - '0';
                }
            }

            subset(0);
            sb.append(String.format("#%d %d\n", tc, result));
        }
        System.out.println(sb);
    }

    private static void subset(int depth) {
        if (result == 0) return;
        if (depth == N) {
            result = Math.min(result, countStone());
            return;
        }

        int[][] copyMap = new int[H][W];
        Copy(copyMap, map);
        boolean exit = true;
        for (int i = 0; i < W; i++) {
            if (isCan(i)) {
                exit = false;
                bomb(i);
                subset(depth + 1);
                Copy(map, copyMap);
            }
        }

        // 만약 벽돌을 던질 곳이 아무곳도 없다면 전부 깨진 상태
        if (exit) {
            result = 0;
        }
    }

    private static int countStone() {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isCan(int pos) {
        for (int i = 0; i < H; i++) {
            if (map[i][pos] != 0) {
                return true;
            }
        }
        return false;
    }

    private static void Copy(int[][] to, int[][] from) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    private static void bomb(int pos) {
        int at = 0;
        for (int i = 0; i < H; i++) {
            if (map[i][pos] != 0) {
                at = i;
                break;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{at, pos, map[at][pos] - 1});
        map[at][pos] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int range = cur[2];

            for (int i = 0; i < 4; i++) {
                int nX = cur[0];
                int nY = cur[1];
                int count = 0;

                while (count < range) {
                    nX += dirX[i];
                    nY += dirY[i];
                    if (!isIn(nX, nY)) {
                        break;
                    }
                    count++;
                    if(map[nX][nY] == 0){
                        continue;
                    }
                    if (map[nX][nY] > 1) {
                        queue.add(new int[]{nX, nY, map[nX][nY] - 1});
                    }
                    map[nX][nY] = 0;
                }
            }
        }
        stoneDown();
    }

    private static void stoneDown() {
        Queue<int[]> pos = new LinkedList<>();
        for (int j = 0; j < W; j++) {
            pos.clear();
            for (int i = H - 1; i >= 0; i--) {
                // 빈공간 위치 저장
                if (map[i][j] == 0) {
                    pos.add(new int[]{i, j});
                }
                // 만약 빈공간이 있는데 0이 아닌 값이 존재한다면 중력 작용
                else if (map[i][j] != 0 && !pos.isEmpty()) {
                    int[] downPos = pos.poll();
                    map[downPos[0]][downPos[1]] = map[i][j];
                    map[i][j] = 0;
                    pos.add(new int[]{i, j});
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}
