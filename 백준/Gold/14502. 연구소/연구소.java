import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] map,copyMap;
    static int result, n, m;
    // 바이러스를 퍼뜨리기 위한 상하좌우
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    // 바이러스의 위치를 저장하는 ArrayList
    static ArrayList<int[]> virusPos = new ArrayList<>();
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 방금 입력 받은 곳이 바이러스라면 바이러스의 위치를 따로 저장해준다.
                if (map[i][j] == 2) {
                    virusPos.add(new int[]{i, j});
                }
            }
        }

        installWall(0);
        System.out.println(result);
    }

    // 벽을 설치하는 메서드(dfs)
    private static void installWall(int count) {
        // 3개 전부 설치 했다면 바이러스를 퍼뜨리고 안전한 공간을 세어준다.
        if (count == 3) {
            virus();
            countSafeZone();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 벽이 아니라면
                if(map[i][j] == 0){
                    // 벽 설치 후
                    map[i][j] = 1;
                    // 재귀 호출(dfs)
                    installWall(count + 1);
                    // 그 후 다시 벽을 제거함
                    map[i][j] = 0;
                }
            }
        }
    }

    // 맵의 상태를 복사 시켜주는 메서드
    private static void getCopy() {
        // copyMap에 기존 맵의 상태를 복사하여 저장 시켜준다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    // 바이러스를 퍼뜨리는 메서드(bfs)
    private static void virus() {
        // copyMap에 map 상태를 저장함
        getCopy();
        // 퍼지는 바이러스들의 위치를 저장하기 위한 큐
        Queue<int[]> queue = new LinkedList<>();

        // 입력 받았을 때 저장했던 바이러스들의 위치
        for (int[] v : virusPos) {
            queue.offer(v);

            while(!queue.isEmpty()){
                int[] tmp = queue.poll();
                int curX = tmp[0];
                int curY = tmp[1];

                for (int i = 0; i < 4; i++) {
                    int nX = curX + dirX[i];
                    int nY = curY + dirY[i];

                    // 배열 범위 밖이거나 Or 위치가 바이러스 혹은 벽인 경우는 제외
                    if (check(nX, nY) || copyMap[nX][nY] != 0) {
                        continue;
                    }

                    // 바이러스 퍼지는 것 입력 후 큐에 삽입
                    copyMap[nX][nY] = 2;
                    queue.offer(new int[]{nX, nY});
                }
            }
        }
    }

    // 범위 밖이라면 true
    private static boolean check(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    // 안전한 영역을 세어준다.
    private static void countSafeZone() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }
        // 더 많은 공간이라면 갱신
        result = Math.max(count, result);
    }
}