import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;

    static int[] dirX = {-1, 1, 0, 0, -1, 1, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dirY = {0, 0, -1, 1, -1, -1, 1, 1, -2, -1, 1, 2, 2, 1, -1, -2};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int x, y;
        ArrayList<int[]> queens = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
            queens.add(new int[]{x, y});
        }

        st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());
        for (int i = 0; i < count; i++) {
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
            night(x, y);
        }

        st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());
        for (int i = 0; i < count; i++) {
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        for (int[] q : queens) {
            queen(q);
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void night(int x, int y) {
        for (int i = 8; i < 16; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            if (isIn(nX, nY) && map[nX][nY] != 1) map[nX][nY] = 2;
        }
    }

    private static void queen(int[] q) {
        for (int i = 0; i < 8; i++) queenMove(q[0], q[1], i);
    }

    private static void queenMove(int x, int y, int d) {
        while (true) {
            int nX = x + dirX[d];
            int nY = y + dirY[d];
            if (!isIn(nX, nY) || map[nX][nY] == 1) break;
            x = nX;
            y = nY;
            map[nX][nY] = 2;
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 & y < M;
    }
}