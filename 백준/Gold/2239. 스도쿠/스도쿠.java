import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map = new int[9][9];
    static int[][] pos = new int[81][2];
    static int limit;

    public static void main(String[] a) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = input.charAt(j) - '0';
                if (map[i][j] == 0) {
                    pos[limit][0] = i;
                    pos[limit++][1] = j;
                }
            }
        }
        solve(0);
    }

    private static void solve(int depth) {
        if (depth == limit) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        int[] curPos = pos[depth];
        for (int i = 1; i <= 9; i++) {
            if (isValid(curPos, i)) {
                map[curPos[0]][curPos[1]] = i;
                solve(depth + 1);
                map[curPos[0]][curPos[1]] = 0;
            }
        }
    }

    private static boolean isValid(int[] curPos, int value) {
        int x = curPos[0];
        int y = curPos[1];
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == value || map[i][y] == value) {
                return false;
            }
        }

        int dX = (x / 3) * 3;
        int dY = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[dX + i][dY + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
