import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static Point[][] prev;
    static int[][] visit;
    static int N, M;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Point[] A = new Point[2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            A[i] = new Point(y, x);
        }

        Point[] B = new Point[2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            B[i] = new Point(y, x);
        }

        int answer = connectCheck(A, B);
        answer = Math.min(answer, connectCheck(B, A));
        if (answer == Integer.MAX_VALUE) {
            System.out.println(IMPOSSIBLE);
        }else{
            System.out.println(answer);
        }
    }

    private static int connectCheck(Point[] A, Point[] B) {
        visit = new int[N + 1][M + 1];
        visit[B[0].x][B[0].y] = visit[B[1].x][B[1].y] = 1;
        prev = new Point[N + 1][M + 1];

        connect(A);
        int aLen = visit[A[1].x][A[1].y];

        visit = new int[N + 1][M + 1];
        Point cur = prev[A[1].x][A[1].y];
        while (cur.x != A[0].x || cur.y != A[0].y) {
            visit[cur.x][cur.y] = 1;
            cur = prev[cur.x][cur.y];
        }
        visit[A[0].x][A[0].y] = visit[A[1].x][A[1].y] = 1;

        connect(B);
        int bLen = visit[B[1].x][B[1].y];
        if (aLen == 0 || bLen == 0) {
            return Integer.MAX_VALUE;
        } else {
            return aLen + bLen;
        }
    }

    private static void connect(Point[] p) {
        Queue<Point> q = new LinkedList<>();
        q.add(p[0]);

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dirX[i];
                int nY = cur.y + dirY[i];

                if (!isIn(nX, nY) || visit[nX][nY] != 0) {
                    continue;
                }
                q.add(new Point(nX, nY));
                visit[nX][nY] = visit[cur.x][cur.y] + 1;
                prev[nX][nY] = cur;
                if (nX == p[1].x && nY == p[1].y) {
                    return;
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x <= N && y >= 0 && y <= M;
    }
}