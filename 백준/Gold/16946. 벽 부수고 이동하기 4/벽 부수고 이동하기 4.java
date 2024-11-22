import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n, m;
    private static int[][] map, idxToMap;
    private static HashMap<Integer, Integer> idx2value = new HashMap<>();

    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Queue<Point> empty = new LinkedList<>();
        Queue<Point> wall = new LinkedList<>();

        // Input
        map = new int[n][m];
        idxToMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
                Point p = new Point(i, j);
                if (map[i][j] == 1) wall.add(p);
                else empty.add(p);
            }
        } // Input End

        int idx = 1;
        while (!empty.isEmpty()) {
            Point p = empty.poll();
            if (idxToMap[p.x][p.y] != 0) {
                continue;
            }
            solve(p, idx);
            idx++;
        }

        idx2value.put(0, 0);
        while (!wall.isEmpty()) {
            Point p = wall.poll();
            int emptyCount = getEmptyCount(p);
            map[p.x][p.y] = (emptyCount + 1) % 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void solve(Point p, int idx) {
        Queue<Point> queue = new LinkedList<>();
        idxToMap[p.x][p.y] = idx;
        queue.add(p);
        int count = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dirX[i];
                int nY = cur.y + dirY[i];

                if (!isIn(nX, nY) || map[nX][nY] != 0 || idxToMap[nX][nY] != 0) {
                    continue;
                }
                idxToMap[nX][nY] = idx;
                queue.offer(new Point(nX, nY));
            }
        }
        idx2value.put(idx, count);
    }

    private static int getEmptyCount(Point p) {
        HashSet<Integer> visited = new HashSet<>();
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            int nX = p.x + dirX[i];
            int nY = p.y + dirY[i];
            if (isIn(nX, nY) && !visited.contains(idxToMap[nX][nY])) {
                ret += idx2value.get(idxToMap[nX][nY]);
                visited.add(idxToMap[nX][nY]);
            }
        }
        return ret;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}