import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int w = 0, b = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'W') {
                    int tmp = dfs(i,j);
                    w += tmp * tmp;
                } else if (map[i][j] == 'B') {
                    int tmp = dfs(i,j);
                    b += tmp * tmp;
                }
            }
        }
        System.out.println(w + " " + b);

    }

    private static int dfs(int x, int y) {
        int count = 1;
        char color = map[x][y];
        map[x][y] = ' ';
        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            if (nX < 0 || nX >= N || nY < 0 || nY >= M || map[nX][nY] != color) {
                continue;
            }
            count += dfs(nX, nY);
        }
        return count;
    }
}