import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] trafficBoard;
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        trafficBoard = new boolean[N][M];

        // Input
        int K = Integer.parseInt(br.readLine());
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken()) - 1;
            int D = Integer.parseInt(st.nextToken());
            trafficBoard[R][C] = true;
            trafficCheck(R, C, D);
        } // Input End

        int result = go();
        if (result == -1) {
            System.out.println("NO");
        }else{
            System.out.println("YES");
            System.out.println(result);
        }
    }

    private static void trafficCheck(int r, int c, int d) {
        for (int i = 0; i < d; i++) {
            if (isIn(r - d + i, c + i)) {
                trafficBoard[r - d + i][c + i] = true;
            }
            if (isIn(r + i, c + d - i)) {
                trafficBoard[r + i][c + d - i] = true;
            }
            if (isIn(r + d - i, c - i)) {
                trafficBoard[r + d - i][c - i] = true;
            }
            if (isIn(r - i, c - d + i)) {
                trafficBoard[r - i][c - d + i] = true;
            }
        }
    }

    private static int go() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        trafficBoard[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                return cur[2];
            }
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];
                if(!isIn(nX,nY) || trafficBoard[nX][nY]) {
                    continue;
                }
                trafficBoard[nX][nY] = true;
                q.add(new int[]{nX, nY, cur[2] + 1});
            }
        }

        return -1;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}