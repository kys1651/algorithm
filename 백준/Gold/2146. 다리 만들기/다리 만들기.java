import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int N, result;
    static int[][] map;

    // 섬 경계에 있는 위치
    static ArrayList<int[]> boundaryList = new ArrayList<>();

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // Input
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(2 * j) - '0';
            }
        }// Input End

        // 각 섬에 인덱스를 부여한다.
        int idx = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 1이라면 아직 인덱스가 부여되지 않은 경우
                if (map[i][j] == 1) {
                    map[i][j] = idx++;
                    dfs(i, j);
                }

                // 경계인지 확인
                if (map[i][j] != 0 && isBoundary(i, j)) {
                    boundaryList.add(new int[]{i, j});
                }
            }
        }

        result = N * N + 1;
        for (int[] b : boundaryList) {
            linkBoundary(b[0], b[1]);
        }

        System.out.println(result);
    }

    private static void linkBoundary(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});

        boolean[][] visit = new boolean[N][N];
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[2] >= result) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (!isIn(nX, nY) || map[nX][nY] == map[x][y] || visit[nX][nY]) {
                    continue;
                }

                visit[nX][nY] = true;
                if (map[nX][nY] == 0) {
                    queue.add(new int[]{nX, nY, cur[2] + 1});
                } else {
                    result = Math.min(result, cur[2]);
                }
            }
        }
    }

    private static boolean isBoundary(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            if (isIn(nX, nY) && map[nX][nY] != map[x][y]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    // 현재 섬의 숫자를 전부 퍼뜨려준다.
    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];
            if(isIn(nX,nY) && map[nX][nY] == 1){
                map[nX][nY] = map[x][y];
                dfs(nX, nY);
            }
        }
    }
}
