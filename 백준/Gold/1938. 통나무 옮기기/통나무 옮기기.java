import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Tree {
        Point s;
        Point m;
        Point e;
        int isRow;
        int count;

        public Tree(Point s, Point m, Point e, int isRow, int count) {
            this.s = s;
            this.m = m;
            this.e = e;
            this.isRow = isRow;
            this.count = count;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point o) {
            return x == o.x && y == o.y;
        }
    }

    static boolean[][][] visit;
    static boolean[][] map;

    static int[] dirX = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dirY = {0, 0, -1, 1, -1, 1, 1, -1};

    static Point endS, endE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        visit = new boolean[2][N][N];
        endE = new Point(0, 0);
        Tree start = new Tree(null, null, null, 0, 0);

        // Input
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = input.charAt(j);
                if (ch == 'B') {
                    if (start.s == null) start.s = new Point(i, j);
                    else if (start.m == null) start.m = new Point(i, j);
                    else start.e = new Point(i, j);
                }
                if (ch == 'E') {
                    if (endS == null) endS = new Point(i, j);
                    endE.x = i;
                    endE.y = j;
                }
                if (ch != '1') {
                    map[i][j] = false;
                } else {
                    map[i][j] = true;
                }
            }
        }// Input End

        if (start.s.y == start.e.y) start.isRow = 1;
        System.out.println(bfs(start));
    }

    private static int bfs(Tree start) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(start);
        visit[start.isRow][start.s.x][start.s.y] = true;
        visit[start.isRow][start.e.x][start.e.y] = true;
        while (!queue.isEmpty()) {
            Tree cur = queue.poll();

            if (endS.equals(cur.s) && endE.equals(cur.e)) {
                return cur.count;
            }
            // 상,하,좌,우 먼저 확인
            for (int i = 0; i < 4; i++) {
                Point nS = new Point(cur.s.x + dirX[i], cur.s.y + dirY[i]);
                Point nM = new Point(cur.m.x + dirX[i], cur.m.y + dirY[i]);
                Point nE = new Point(cur.e.x + dirX[i], cur.e.y + dirY[i]);
                if (!isIn(nS) || !isIn(nM) || !isIn(nE) || (visit[cur.isRow][nS.x][nS.y] && visit[cur.isRow][nE.x][nE.y])) {
                    continue;
                }
                visit[cur.isRow][nS.x][nS.y] = visit[cur.isRow][nE.x][nE.y] = true;
                queue.add(new Tree(nS, nM, nE, cur.isRow, cur.count + 1));
            }
            // 회전 확인
            if (!isPossible(cur.m)) {
                continue;
            }
            Point nS = null;
            Point nE = null;
            int nextRow = (cur.isRow + 1) % 2;
            if (cur.isRow == 0) {
                nS = new Point(cur.m.x - 1, cur.m.y);
                nE = new Point(cur.m.x + 1, cur.m.y);
            } else {
                nS = new Point(cur.m.x, cur.m.y - 1);
                nE = new Point(cur.m.x, cur.m.y + 1);
            }
            if (!isIn(nS) || !isIn(nE) || (visit[nextRow][nS.x][nS.y] && visit[nextRow][nE.x][nE.y])) {
                continue;
            }
            visit[nextRow][nS.x][nS.y] = visit[nextRow][nE.x][nE.y] = true;
            queue.add(new Tree(nS, cur.m, nE, nextRow, cur.count + 1));
        }
        return 0;
    }

    private static boolean isIn(Point p) {
        return p.x >= 0 && p.x < N && p.y >= 0 && p.y < N && !map[p.x][p.y];
    }

    private static boolean isPossible(Point p) {
        for (int i = 0; i < 8; i++) {
            int nX = p.x + dirX[i];
            int nY = p.y + dirY[i];
            if (!isIn(new Point(nX, nY))) {
                return false;
            }
        }
        return true;
    }
}
