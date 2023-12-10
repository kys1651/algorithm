import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int[][] map;
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();
    static int[] dirX = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dirY = {-1, 1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h, w;
        while (true) {
            // h, w 입력
            h = sc.nextInt();
            w = sc.nextInt();
            // 둘 다 0이면 종료
            if (h == 0 && w == 0) {
                break;
            }

            // 섬과 바다를 입력 받을 map
            map = new int[w][h];
            // 방문 확인을 위한 visit
            visit = new boolean[w][h];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int result = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    // map가 섬이고 방문하지 않았다면 result 증가 후 섬 방문 확인
                    if (map[i][j] == 1 && !visit[i][j]) {
                        result++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visit[x][y] = true;
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            // 현재 섬의 위치
            int cur[] = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            // 주변 상,하,좌,우,각 대각를 기준으로 확인
            for (int i = 0; i < dirX.length; i++) {
                int nextX = curX + dirX[i];
                int nextY = curY + dirY[i];

                // 배열의 크기 밖이라면 continue;
                if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[nextX].length) {
                    continue;
                }
                // 방문할 곳이 바다거나 방문했다면 continue;
                if (map[nextX][nextY] == 0 || visit[nextX][nextY]) {
                    continue;
                }
                visit[nextX][nextY] = true;
                queue.offer(new int[] {nextX, nextY});
            }
        }
    }
}
