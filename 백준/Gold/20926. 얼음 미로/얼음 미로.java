import java.io.*;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int weight;

        public Point(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return this.weight - o.weight;
        }
    }

    static int[][] map, weight;
    static int W, H;
    static Point e;
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        weight = new int[H][W];

        // Input
        Point s = new Point(0, 0, 0);
        e = new Point(0, 0, 0);
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                char ch = input.charAt(j);
                map[i][j] = Integer.MAX_VALUE;
                if (ch == 'R') {
                    map[i][j] = -1;
                } else if (ch == 'H') {
                    map[i][j] = -2;
                } else if (ch >= '0' && ch <= '9') {
                    weight[i][j] = ch - '0';
                } else if (ch == 'T') {
                    map[i][j] = 0;
                    s.x = i;
                    s.y = j;
                } else if (ch == 'E') {
                    e.x = i;
                    e.y = j;
                }
            }
        }// Input End

        dijkstra(s);
        System.out.println(map[e.x][e.y] == Integer.MAX_VALUE ? -1 : map[e.x][e.y]);
    }

    private static void dijkstra(Point s) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (map[cur.x][cur.y] < cur.weight) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                Point next = getNextPosition(cur, i);
                if (next == null) {
                    continue;
                }
                if (map[next.x][next.y] > next.weight) {
                    map[next.x][next.y] = next.weight;
                    queue.add(next);
                }
            }
        }
    }

    private static Point getNextPosition(Point cur, int d) {
        Point next = new Point(cur.x, cur.y, cur.weight);
        while (true) {
            int nX = next.x + dirX[d];
            int nY = next.y + dirY[d];
            if (!isIn(nX, nY) || map[nX][nY] == -2) {
                return null;
            } else if (map[nX][nY] == -1) {
                return next;
            }
            next.x = nX;
            next.y = nY;
            next.weight += weight[nX][nY];
            if (nX == e.x && nY == e.y) {
                map[next.x][next.y] = Math.min(next.weight, map[next.x][next.y]);
                return null;
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}