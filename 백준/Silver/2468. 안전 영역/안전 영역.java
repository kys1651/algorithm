import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visit;

    // 방향 -> 상,하,좌,우
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        HashSet<Integer> safeZoneInfo = new HashSet<>();
//        // 아무 지역도 물에 잠기지 않는 경우
//        safeZoneInfo.add(0);
        // Input
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                safeZoneInfo.add(map[i][j]);
            }
        }

        // checkSafeZone
        int maxSafe = 1;
        for (int height : safeZoneInfo) {
            visit = new boolean[N][N];

            int safeCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > height && !visit[i][j]) {
                        safeCount++;
                        dfs(i, j,height);
                    }
                }
            }
            if (maxSafe < safeCount) maxSafe = safeCount;
        }

        System.out.println(maxSafe);
    }

    private static void dfs(int x, int y, int height) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            // 배열 범위 밖이거나 || 제한 높이보다 낮거나 같거나 || 방문했다면 continue;
            if (nX < 0 || nX >= N || nY < 0 || nY >= N || map[nX][nY] <= height || visit[nX][nY]) {
                continue;
            }

            dfs(nX, nY, height);
        }
    }
}