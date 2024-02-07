import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int R, C, K, result;
    static char[][] map;
    static boolean[][] visit;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken())-1;

        map = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        visit[R-1][0] = true;
        go(0, R - 1, 0);

        System.out.println(result);
    }

    private static void go(int depth, int x, int y) {
        if (depth == K) {
            if (x == 0 && y == C - 1) {
                result++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            if (0 > nX || nX >= R || nY < 0 || nY >= C || visit[nX][nY] || map[nX][nY] == 'T') {
                continue;
            }

            visit[nX][nY] = true;
            go(depth + 1, nX, nY);
            visit[nX][nY] = false;
        }
    }
}
