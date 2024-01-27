import java.util.*;
import java.io.*;

public class Main {
    // 지도, 디피배열
    static int[][] map, dp;
    // 세로,가로
    static int m, n;
    // 델타를 이용한 방향
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m + 1][n + 1];
        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // dp초기화
            }
        }

        System.out.println(dfs(1, 1));
    }

    // dfs를 통해 계산 Memozation을 통해 메모리 아낌
    private static int dfs(int x, int y) {
        // 도착지점까지 도달했을 경우
        if (x == m && y == n) {
            return 1;
        }

        //  방문한 적이 있는 경우
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int count = 0;
        for (int d = 0; d < 4; d++) {
            int nX = x + dirX[d];
            int nY = y + dirY[d];

            // 배열밖이거나 현재보다 같거나 큰 경우 넘어간다.
            if (nX < 1 || nX > m || nY < 1 || nY > n || map[x][y] <= map[nX][nY]) {
                continue;
            }

            // 내리막 길인 경우
            count += dfs(nX, nY);
        }
        dp[x][y] = count;
        return dp[x][y];
    }
}