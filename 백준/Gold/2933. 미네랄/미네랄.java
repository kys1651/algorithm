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

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static int R, C, maxHeight, gap;
    static int[][] map;
    static Queue<Point> clusterQueue = new LinkedList<>();
    static Queue<Point> underQueue = new LinkedList<>();


    // 클러스터가 사라지면 체크해주는 방향 배열
    static int[] dirX = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dirY = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // Input
        String input;
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j) == '.' ? 0 : 1;
            }
        } // Input End

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int posX = R - Integer.parseInt(st.nextToken());
            int posY = getPos(posX, i % 2 == 0);

            if (posY == -1) continue;

//            System.out.println("폭발지점 : " + posX + " " + posY);
            map[posX][posY] = 0; // 지워준 뒤 만약 그곳이 중간 클러스터였다면 주위에 연결이 끊어진 클러스터가 있다.

//            print();

            // 이 지점을 지나면 낙하 클러스터가 전부 pq에 담김
            getCluster(posX, posY);

//            System.out.println(underQueue);
            if (!underQueue.isEmpty()) fallCluster();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j] == 0 ? '.' : 'x');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void fallCluster() {
        gap = 101;
        getMaxPos();
//        System.out.println("작은 값에서 내려간 경우 가장 위에 있는 클러스터 차이: " + gap + " -> 위치");
        while (!clusterQueue.isEmpty()) {
            Point cur = clusterQueue.poll();
            map[cur.x + gap][cur.y] = 1;
        }
    }

    private static void getMaxPos() {
        while (!underQueue.isEmpty()) {
            Point point = underQueue.poll();
            int x = point.x;
//            System.out.println(point + " start ");
            while (true) {
                int nX = x + 1;
                // 클러스터 만나거나 땅인 경우
                if (nX == R || map[nX][point.y] == 1) {
                    int newGap = nX - point.x - 1;
//                    System.out.println("새로운 지점 " + nX + " 기존 지점 " + point.x + " 차이 " + newGap);
                    if (newGap < gap) {
                        gap = newGap;
                    }
                    break;
                }
                x = nX;
            }
        }
    }

    // 클러스터가 끊긴다면 좌우 위 라인 3개가 끊어질 수 있음
    private static void getCluster(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nX = x + dirX[i];
            int nY = y + dirY[i];

            // 범위내이고 연결된 곳이고 그게 공중에 떠있는 곳이라면 큐에 담겨있는 것이므로 종료
            if (isIn(nX, nY) && map[nX][nY] == 1 && isFly(nX, nY, false)) {
                maxHeight = -1;
                isFly(nX, nY, true);
                return;
            }
        }
    }

    private static boolean isFly(int x, int y, boolean get) {
        boolean[][] visit = new boolean[R][C];
        Queue<Point> q = new LinkedList<>();
        Point startPoint = new Point(x, y);
        q.add(startPoint);
        if(get) {
            map[x][y] = 0;
            clusterQueue.add(startPoint);
            underQueue.add(startPoint);
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == R - 1) {
                return false;
            }
            for (int i = 0; i < 4; i++) {
                int nX = p.x + dirX[i];
                int nY = p.y + dirY[i];

                if (isIn(nX, nY) && map[nX][nY] == 1 && !visit[nX][nY]) {
                    visit[nX][nY] = true;
                    Point next = new Point(nX, nY);
                    q.add(next);
                    if (get) {
                        clusterQueue.add(next);
                        underQueue.add(next);
                        map[nX][nY] = 0;
                    }
                }
            }
        }

//        System.out.println(x + " " + y + "관련 전부 담음");
        return true;
    }

    private static int getPos(int pos, boolean dir) {
        int y = dir ? -1 : C;
        int d = dir ? 1 : -1;

        while (true) {
            int nY = y + d;
            if (!isIn(pos, nY)) {
                break;
            }
            if (map[pos][nY] == 0) {
                y = nY;
            } else {
                return nY;
            }
        }
        return -1;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] == 1 ? 'x' : '.');
            }
            System.out.println();
        }
        System.out.println();
    }
}