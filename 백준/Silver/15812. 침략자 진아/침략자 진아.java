import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map, copyMap;
    static int n, m, result = Integer.MAX_VALUE;
    static Point a, b;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static ArrayList<Point> home = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copyMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
                if(map[i][j] == 1){
                    home.add(new Point(i, j));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 마을이면 넘김
                if (map[i][j] == 1) continue;
                // 빈 공간이면 가능한 곳 호출
                a = new Point(i, j);
                searchPossible(i, j);
            }
        }
        System.out.println(result);
    }

    private static void searchPossible(int x, int y) {
        for (int i = x; i < n; i++) {
            for (int j = y; j < m; j++) {
                // 마을이면 넘김
                if (map[i][j] == 1) continue;
                // 두번째 빈공간 찾음
                b = new Point(i, j);
                // 퍼뜨리기
                bfs();
            }
        }
    }

    private static void bfs() {
        // 배열 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(a);
        queue.add(b);
        // 시작점 전염병 넣어둠
        copyMap[a.x][a.y] = 2;
        copyMap[b.x][b.y] = 2;

        // 시간 메모
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                Point pos = queue.poll();

                for (int d = 0; d < dirX.length; d++) {
                    int nX = pos.x + dirX[d];
                    int nY = pos.y + dirY[d];

                    // 유효하지않거나 전염된 곳이라면 넘어감
                    if (!isValid(nX, nY) || copyMap[nX][nY] == 2) {
                        continue;
                    }

                    copyMap[nX][nY] = 2;
                    queue.offer(new Point(nX, nY));
                }
            }
            // 전부 퍼뜨려졌는지 확인
            if (bruteCheck()) {
                // 전부 퍼뜨려졌다면 최소값 갱신
                result = Math.min(result, time);
                return;
            }
        }
    }

    private static boolean bruteCheck() {
        for (Point p : home) {
            if(copyMap[p.x][p.y] == 1){
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}