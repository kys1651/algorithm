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

    private static int[] dirX = {0, 0, 1, -1};
    private static int[] dirY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];
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
        int eX = Integer.parseInt(st.nextToken()) - 1;
        int eY = Integer.parseInt(st.nextToken()) - 1;
        int eDir = Integer.parseInt(st.nextToken()) - 1;

        int[][][] visit = new int[4][N][M];
        visit[s.d][sX][sE] = 0;
        Queue<Robot> queue = new LinkedList<>();
        queue.add(s);
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Robot r = queue.poll();

            if (r.count >= result) {
                continue;
            }
            if (r.x == eX && r.y == eY && r.d == eDir) {
                if (result > r.count) {
                    result = r.count;
                }
                continue;
            }
            int nextDir = getLeft(r.d);
            if (visit[nextDir][r.x][r.y] == 0 || visit[nextDir][r.x][r.y] > r.count + 1) {
                visit[nextDir][r.x][r.y] = r.count + 1;
                queue.add(new Robot(r.x, r.y, nextDir, r.count + 1));
            }
            nextDir = getRight(r.d);
            if (visit[nextDir][r.x][r.y] == 0 || visit[nextDir][r.x][r.y] > r.count + 1) {
                visit[nextDir][r.x][r.y] = r.count + 1;
                queue.add(new Robot(r.x, r.y, nextDir, r.count + 1));
            }
            for (int i = 1; i <= 3; i++) {
                int nX = r.x + dirX[r.d] * i;
                int nY = r.y + dirY[r.d] * i;
                if (!isIn(nX, nY, N, M) || map[nX][nY]) {
                    break;
                }
                if (visit[r.d][nX][nY] == 0 || visit[r.d][nX][nY] > r.count + 1) {
                    visit[r.d][nX][nY] = r.count + 1;
                    queue.add(new Robot(nX, nY, r.d, r.count + 1));
                }
            }
        }
        System.out.println(visit[eDir][eX][eY]);
    }

    private static boolean isIn(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static int getRight(int d) {
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
    }

    private static int getLeft(int d) {
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