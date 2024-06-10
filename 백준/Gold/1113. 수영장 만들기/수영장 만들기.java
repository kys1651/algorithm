import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static Queue<Point> queue = new LinkedList<>();
    static int[][] pool;
    static int N, M;

    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pool = new int[N][M];

        // Input
        // 시작 범위와 종료 범위
        int s = 10, e=0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                pool[i][j] = input.charAt(j) - '0';
                if (s > pool[i][j]) {
                    s = pool[i][j];
                }
                if (e < pool[i][j]) {
                    e = pool[i][j];
                }
            }
        } // Input End

        int answer = 0;
        // 현재 높이 h에서 채울 수 있는 모든 칸 탐색
        for (int h = s; h <= e; h++) {
            // 테두리는 물이 될 수 없으므로 제외하고 계산한다.
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (pool[i][j] == h) {
                        answer += bfs(h, i, j);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int depth, int x, int y) {
        queue.add(new Point(x, y)); // 현재 위치 대입
        pool[x][y] = depth + 1; // 현재 위치에 1증가
        boolean isPossible = true; // 더 할 수 없는지 체크하는 변수
        int count = 1; // 더한 물의 개수

        while(!queue.isEmpty()){
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dirX[i];
                int nY = cur.y + dirY[i];

                // 테두리는 물을 채울 수 없으므로 제외하고 내부의 칸들만 탐색
                if (!isIn(nX, nY) || pool[nX][nY] < depth) {
                    isPossible = false;
                    continue;
                }
                if(pool[nX][nY] == depth){
                    pool[nX][nY] = depth + 1;
                    count++;
                    queue.add(new Point(nX, nY));
                }
            }
        }
        // isPossible가 true면 해당 높이에서 물을 채울 수 있음
        return isPossible ? count : 0;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}