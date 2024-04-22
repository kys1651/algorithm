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
        int row;
        int count;

        public Tree(Point s, Point m, Point e, int row, int count) {
            this.s = s;
            this.m = m;
            this.e = e;
            this.row = row;
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
    }

    // 상,하,좌,우 왼쪽 위 대각, 오른쪽 위 대각, 오른쪽 아래 대각, 왼쪽 아래 대각
    static int[] dirX = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dirY = {0, 0, -1, 1, -1, 1, 1, -1};
    static boolean[][][] visit;
    static boolean[][] map;
    static Point endS, endM, endE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[2][N][N];
        map = new boolean[N][N];

        // Input
        Tree start = new Tree(null, null, null, 0, 0);
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = input.charAt(j);
                if (ch == 'B') {
                    if (start.s == null) start.s = new Point(i, j);
                    else if (start.m == null) start.m = new Point(i, j);
                    else start.e = new Point(i, j);
                } else if (ch == 'E') {
                    if (endS == null) endS = new Point(i, j);
                    else if (endM == null) endM = new Point(i, j);
                    else endE = new Point(i, j);
                } else if (ch == '1') {
                    map[i][j] = true;
                }
            }
        } // Input End

        if (start.s.y == start.e.y) start.row = 1;
        System.out.println(bfs(start));
    }

    private static int bfs(Tree start) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(start);
        visit[start.row][start.s.x][start.s.y] = visit[start.row][start.e.x][start.e.y] = true;
        while (!queue.isEmpty()) {
            Tree cur = queue.poll();
            if (cur.s.x == endS.x && cur.s.y == endS.y && cur.e.x == endE.x && cur.e.y == endE.y) {
                return cur.count;
            }
            // 상,하,좌,우
            for (int i = 0; i < 4; i++) {
                int nSX = cur.s.x + dirX[i];
                int nSY = cur.s.y + dirY[i];
                int nEX = cur.e.x + dirX[i];
                int nEY = cur.e.y + dirY[i];
                int nMX = cur.m.x + dirX[i];
                int nMY = cur.m.y + dirY[i];
                // 나무가 있거나 범위밖이거나 방문한 적 있으면 갈 필요 X
                if (!isIn(nSX, nSY) || !isIn(nEX, nEY) || !isIn(nMX, nMY) || (visit[cur.row][nSX][nSY] && visit[cur.row][nEX][nEY])) {
                    continue;
                }
                visit[cur.row][nSX][nSY] = visit[cur.row][nEX][nEY] = true;
                queue.add(new Tree(new Point(nSX, nSY), new Point(nMX, nMY), new Point(nEX, nEY), cur.row, cur.count + 1));
            }

            boolean can = true;
            for (int i = 0; i < 8; i++) {
                int nX = cur.m.x + dirX[i];
                int nY = cur.m.y + dirY[i];
                if (!isIn(nX, nY)) {
                    can = false;
                    break;
                }
            }

            if (!can) continue;
            int nSX = cur.m.x, nSY = cur.m.y;
            int nEX = cur.m.x, nEY = cur.m.y;
            int nRow = (cur.row + 1) % 2;
            // 현재 행이라면 열로 변경
            if (cur.row == 0) {
                nSX = cur.m.x - 1;
                nEX = cur.m.x + 1;
            } else {
                nSY = cur.m.y - 1;
                nEY = cur.m.y + 1;
            }
            if (!(visit[nRow][nSX][nSY] && visit[nRow][nEX][nEY])) {
                visit[nRow][nSX][nSY] = visit[nRow][nEX][nEY] = true;
                queue.add(new Tree(new Point(nSX, nSY), cur.m, new Point(nEX, nEY), nRow, cur.count + 1));
            }
        }
        return 0;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && !map[x][y];
    }
}
