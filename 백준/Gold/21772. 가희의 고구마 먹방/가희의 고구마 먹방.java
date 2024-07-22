import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int R, C, result;

    static int[] dirX = {-1, 1, 0, 0, 0};
    static int[] dirY = {0, 0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        // Input
        int sX = 0, sY = 0;
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = input.charAt(j);
                if (ch == 'G') {
                    sX = i;
                    sY = j;
                } else if (ch == 'S') {
                    map[i][j] = 1;
                } else if (ch == '#') {
                    map[i][j] = -1;
                }
            }
        }// Input End

        solve(sX, sY, 0, T);
        System.out.println(result);
    }

    private static void solve(int x, int y, int count, int time) {
        if (time == 0) {
            result = Math.max(result, count);
            return;
        }

        for (int i = 0; i < 5; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            if (!isIn(nX, nY) || map[nX][nY] == -1) continue;

            int prev = map[nX][nY];
            map[nX][nY] = 0;
            solve(nX, nY, count + prev, time - 1);
            map[nX][nY] = prev;
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}