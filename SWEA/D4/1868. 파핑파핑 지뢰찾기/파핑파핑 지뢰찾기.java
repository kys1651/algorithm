import java.util.*;
import java.io.*;

public class Solution {
    static int[][] map;
    static int[] dirX = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dirY = {-1, 0, 1, 1, 1, 0, -1, -1};

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            // Input
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    char ch = input.charAt(j);
                    if (ch == '*') {
                        map[i][j] = -2;
                    } else {
                        map[i][j] = -1;
                    }
                }
            }// Input End

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == -2 || map[i][j] != -1) {
                        continue;
                    }
                    if (getCount(i, j) == 0) {
                        map[i][j] = 0;
                        dfs(i, j);
                        result++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == -1) result++;
                }
            }
            answer.append(String.format("#%d %d\n", tc, result));
        }
        System.out.println(answer);
    }

    private static int getCount(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            if (isIn(nX, nY) && map[nX][nY] == -2) {
                count++;
            }
        }
        return count;
    }

    private static void dfs(int x, int y) {
        if (map[x][y] == -1) {
            map[x][y] = getCount(x, y);
        }

        if (map[x][y] == 0) {
            for (int i = 0; i < 8; i++) {
                int nX = x + dirX[i];
                int nY = y + dirY[i];
                if (isIn(nX, nY) && map[nX][nY] == -1) {
                    dfs(nX, nY);
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

