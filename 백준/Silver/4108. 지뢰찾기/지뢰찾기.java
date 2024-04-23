import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // CW
    static int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dirY = {0, 1, 1, 1, 0, -1, -1, -1};
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (R == 0 && C == 0) {
                break;
            }

            // Input
            char[][] map = new char[R][C];
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
            }// Input End

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '*') {
                        sb.append('*');
                    } else {
                        sb.append(getCount(i, j, map));
                    }
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    private static char getCount(int x, int y, char[][] map) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            if (isIn(nX, nY) && map[nX][nY] == '*') {
                count++;
            }
        }
        return (char)('0' + count);
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
