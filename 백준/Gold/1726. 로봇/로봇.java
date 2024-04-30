import java.util.*;
import java.io.*;

public class Main {
    static class Robot {
        int x;
        int y;
        int d;
        int count;

        public Robot(int x, int y, int d, int count) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.count = count;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Robot{");
            sb.append("x=").append(x + 1);
            sb.append(", y=").append(y + 1);
            sb.append(", d=").append(d + 1);
            sb.append(", count=").append(count);
            sb.append('}');
            return sb.toString();
        }
    }

    private static boolean[][] map;
    private static int[][][] visit;
    private static int[] dirX = {0, 0, 1, -1};
    private static int[] dirY = {1, -1, 0, 0};
    private static int N, M, endX, endY, endDir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        // Input
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j * 2) == '1';
            }
        } // Input End

        st = new StringTokenizer(br.readLine());
        int sX = Integer.parseInt(st.nextToken()) - 1;
        int sE = Integer.parseInt(st.nextToken()) - 1;
        int sDir = Integer.parseInt(st.nextToken()) - 1;
        Robot s = new Robot(sX, sE, sDir, 0);

        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;
        endDir = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs(s));
    }

    private static int bfs(Robot start) {
        Queue<Robot> queue = new LinkedList<>();
        queue.add(start);

        visit = new int[4][N][M];
        while (!queue.isEmpty()) {
            Robot r = queue.poll();

            if (r.x == endX && r.y == endY && r.d == endDir) {
                return r.count;
            }
            int nextDir = getDir(r.d, true);
            if (isRotate(r, nextDir)) {
                visit[nextDir][r.x][r.y] = r.count + 1;
                queue.add(new Robot(r.x, r.y, nextDir, r.count + 1));
            }
            nextDir = getDir(r.d, false);
            if (isRotate(r, nextDir)) {
                visit[nextDir][r.x][r.y] = r.count + 1;
                queue.add(new Robot(r.x, r.y, nextDir, r.count + 1));
            }
            for (int i = 1; i <= 3; i++) {
                int nX = r.x + dirX[r.d] * i;
                int nY = r.y + dirY[r.d] * i;
                if (!isIn(nX, nY, N, M) || map[nX][nY]) {
                    break;
                }
                if (isForward(r, nX, nY)) {
                    visit[r.d][nX][nY] = r.count + 1;
                    queue.add(new Robot(nX, nY, r.d, r.count + 1));
                }
            }
        }
        return 0;
    }

    private static boolean isForward(Robot r, int nX, int nY) {
        return visit[r.d][nX][nY] == 0 || visit[r.d][r.x][r.y] > r.count + 1;
    }

    private static boolean isRotate(Robot r, int next) {
        return visit[next][r.x][r.y] == 0 || visit[next][r.x][r.y] > r.count + 1;
    }

    private static boolean isIn(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static int getDir(int d, boolean right) {
        if (right) {
            switch (d) {
                case 0:
                    return 2;
                case 1:
                    return 3;
                case 2:
                    return 1;
                default:
                    return 0;
            }
        } else {
            switch (d) {
                case 0:
                    return 3;
                case 1:
                    return 2;
                case 2:
                    return 0;
                default:
                    return 1;
            }
        }

    }

}