import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        bfs();
        int result = -1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    result = 0;
                    break;
                } else {
                    result = Math.max(result, map[i][j]);
                }
            }
            if (result == 0) {
                break;
            }
        }
        System.out.println(result - 1);
    }

    private static void bfs() {
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] tomato = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nX = tomato[0] + dirX[d];
                    int nY = tomato[1] + dirY[d];

                    // 배열의 범위 밖인 경우
                    if (nX < 0 || nX >= map.length || nY < 0 || nY >= map[nX].length) {
                        continue;
                    }
                    // 익지 않은 토마토인 경우
                    if (map[nX][nY] == 0) {
                        map[nX][nY] = map[tomato[0]][tomato[1]] + 1;
                        queue.offer(new int[] {nX, nY});
                    }
                }
            }
        }
    }

}