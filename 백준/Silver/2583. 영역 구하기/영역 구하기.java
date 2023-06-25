import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int M, N;
    static int area;

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];
        ArrayList<Integer> list = new ArrayList<>();

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int x = lx; x < rx; x++) {
                for (int y = ly; y < ry; y++) {
                    map[y][x]++;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    area = 0;
                    dfs(i, j);
                    list.add(area);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int n : list) {
            System.out.print(n + " ");
        }

    }

    private static void dfs(int x, int y) {
        area++;
        visited[x][y] = true;

        // 동서남북 확인
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            // map에 범위 내에 있는지 확인함
            if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) {
                continue;
            }

            // 방문 안했고 영역이 0이면 들어가줌
            if (!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                dfs(nextX, nextY);
            }
        }

    }
}
