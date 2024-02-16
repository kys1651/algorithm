import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N, result;
    static char[][] map;

    // 현재 좌표 평면 8 방향 체크
    static int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            result = 0;

            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.') {
                        removeMine(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '.') result++;
                }
            }
            sb.append(String.format("#%d %d\n", tc, result));
        }
        System.out.println(sb);
    }

    private static void removeMine(int x, int y) {
        int count = 0;

        boolean write = false;
        for (int i = 0; i < 8; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            if (!isIn(nX, nY)) {
                continue;
            }
            if (map[nX][nY] == '*') {
                count++;
            }
            if (map[nX][nY] == '0') {
                write = true;
            }
        }

        if (write) {
            map[x][y] = (char) ('0' + count);
        }
        if (count == 0) {
            map[x][y] = '0';
            for (int i = 0; i < 8; i++) {
                int nX = x + dirX[i];
                int nY = y + dirY[i];
                if (isIn(nX, nY)&&map[nX][nY] == '.') {
                    removeMine(x + dirX[i], y + dirY[i]);
                }
            }
            if (!write) {
                result++;
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

