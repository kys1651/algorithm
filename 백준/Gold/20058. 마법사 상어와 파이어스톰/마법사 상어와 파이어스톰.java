import java.util.*;
import java.io.*;

public class Main {
    static int N, total;
    static int[][] map, copyMap;
    static boolean[][] visit;

    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        N = 1 << N;
        int Q = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        copyMap = new int[N][N];

        // Input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// Input End

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            firestorm(1 << L);
        }

        visit = new boolean[N][N];
        int big = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visit[i][j]) {
                    int count = dfs(i, j);
                    if (big < count) big = count;
                }
            }
        }
        System.out.println(total);
        System.out.println(big);
    }

    private static int dfs(int x, int y) {
        visit[x][y] = true;
        int sum = 1;
        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            if (isIn(nX, nY, 0, 0, N) && map[nX][nY] != 0 && !visit[nX][nY]) {
                sum += dfs(nX, nY);
            }
        }
        return sum;
    }

    private static void firestorm(int limit) {
        if (limit != 1) {
            recursion(0, 0, N, limit);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    copyMap[i][j] = 0;
                    continue;
                }
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nX = i + dirX[k];
                    int nY = j + dirY[k];
                    if (isIn(nX, nY, 0, 0, N) && map[nX][nY] != 0) {
                        count++;
                    }
                }
                if (count >= 3) {
                    copyMap[i][j] = map[i][j];
                } else {
                    copyMap[i][j] = map[i][j] - 1;
                }
            }
        }

        total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = copyMap[i][j];
                total += map[i][j];
            }
        }
    }

    private static void recursion(int x, int y, int size, int limit) {
        if (size == limit) {
            rotate(x, y, limit);
        } else {
            int nextSize = size >> 1;
            recursion(x, y, nextSize, limit);
            recursion(x, y + nextSize, nextSize, limit);
            recursion(x + nextSize, y, nextSize, limit);
            recursion(x + nextSize, y + nextSize, nextSize, limit);
        }
    }

    private static void rotate(int x, int y, int limit) {
        int count = limit >> 1;
        for (int i = 0; i < count; i++) {
            int nextLimit = limit - 2 * i;
            for (int j = 1; j < nextLimit; j++) {
                change(x + i, y + i, nextLimit);
            }
        }
    }

    private static void change(int x, int y, int limit) {
        int prev = map[x][y];
        int d = 0;
        int nX = x + dirX[d], nY = y + dirY[d];
        while (!(nX == x && nY == y)) {
            int tmp = map[nX][nY];
            map[nX][nY] = prev;
            prev = tmp;
            if (!isIn(nX + dirX[d], nY + dirY[d], x, y, limit)) {
                d = (d + 1) % 4;
            }
            nX = nX + dirX[d];
            nY = nY + dirY[d];
        }
        map[x][y] = prev;
    }

    private static boolean isIn(int x, int y, int lX, int lY, int limit) {
        return x >= lX && x < lX + limit && y >= lY && y < lY + limit;
    }
}