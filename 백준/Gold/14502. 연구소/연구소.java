import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] map,copyMap;
    static boolean[][] install;
    static int result, n, m;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static ArrayList<int[]> virusPos = new ArrayList<>();
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        install = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    install[i][j] = true;
                } else if (map[i][j] == 2) {
                    virusPos.add(new int[]{i, j});
                }
            }
        }

        installWall(0);
        System.out.println(result);
    }

    private static void installWall(int count) {
        // 3개 전부 설치 함
        if (count == 3) {
            virus();
            countSafeZone();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    installWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void getCopy() {
        copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    private static void virus() {
        getCopy();
        Queue<int[]> queue = new LinkedList<>();
        for (int[] v : virusPos) {
            queue.offer(v);

            while(!queue.isEmpty()){
                int[] tmp = queue.poll();
                int curX = tmp[0];
                int curY = tmp[1];

                for (int i = 0; i < 4; i++) {
                    int nX = curX + dirX[i];
                    int nY = curY + dirY[i];

                    if (check(nX, nY) || copyMap[nX][nY] != 0) {
                        continue;
                    }

                    copyMap[nX][nY] = 2;
                    queue.offer(new int[]{nX, nY});
                }
            }
        }
    }

    private static boolean check(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m){
            return true;
        }
        return false;
    }

    private static void countSafeZone() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }
        result = Math.max(count, result);
    }
}