import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int R, C, result;
    static char[][] map;
    static boolean exit;

    static int[] dirX = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            exit = false;
            dfs(i, 0);
        }

        System.out.println(result);
    }

    private static void print() {
        for (char[] cs : map) {
            for (char c : cs) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int x, int y) {
        if(exit) return;

        map[x][y] = 'x';

        if (y == C - 1) {
            exit = true;
            result++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nX = x + dirX[i];
            int nY = y + 1;

            if (nX < 0 || nX >= R || map[nX][nY] == 'x' || exit) {
                continue;
            }
            dfs(nX, nY);
        }
    }
}