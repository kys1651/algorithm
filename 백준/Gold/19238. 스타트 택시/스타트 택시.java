import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, K;
    static int idx, minDist, minX, minY;
    static int[][] map;
    static Point[] goal;
    static Point taxi;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // Input
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j * 2) - '0';
                if (map[i][j] == 1) map[i][j] = -1;
            }
        }// Input End

        st = new StringTokenizer(br.readLine());
        taxi = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        // Input
        goal = new Point[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = i;
            goal[i] = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }// Input End

        int count = 0;
        while (count != M) {
            idx = -1;
            minX = minY = minDist = Integer.MAX_VALUE;
            getIdx();

            K -= minDist;
            if (K < 0 || idx == -1) {
                break;
            }

            int dist = getDist(minX, minY, goal[idx]);
            K -= dist;
            if (K < 0 || dist == -1) {
                break;
            }
            K += dist * 2;
            taxi.x = goal[idx].x;
            taxi.y = goal[idx].y;
            map[minX][minY] = 0;
            count++;
        }

        if (count == M) {
            System.out.println(K);
        } else {
            System.out.println(-1);
        }
    }

    private static int getDist(int x, int y, Point goal) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        boolean[][] visit = new boolean[N][N];
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (!isIn(nX, nY) || visit[nX][nY] || map[nX][nY] == -1) {
                    continue;
                }

                if (nX == goal.x && nY == goal.y) {
                    return cur[2] + 1;
                }
                queue.add(new int[]{nX, nY, cur[2] + 1});
                visit[nX][nY] = true;
            }
        }
        return -1;
    }

    private static void getIdx() {
        if (map[taxi.x][taxi.y] != 0) {
            minX = taxi.x;
            minY = taxi.y;
            minDist = 0;
            idx = map[taxi.x][taxi.y];
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{taxi.x, taxi.y, 0});

        boolean[][] visit = new boolean[N][N];
        visit[taxi.x][taxi.y] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dirX[i];
                int nY = cur[1] + dirY[i];

                if (!isIn(nX, nY) || visit[nX][nY] || map[nX][nY] == -1) {
                    continue;
                }
                visit[nX][nY] = true;
                if (map[nX][nY] == 0) {
                    queue.add(new int[]{nX, nY, cur[2] + 1});
                } else {
                    if (minDist > cur[2] + 1) {
                        minDist = cur[2] + 1;
                        idx = map[nX][nY];
                        minX = nX;
                        minY = nY;
                    } else if (minDist == cur[2] + 1) {
                        if (minX > nX) {
                            idx = map[nX][nY];
                            minX = nX;
                            minY = nY;
                        } else if (minX == nX && minY > nY) {
                            idx = map[nX][nY];
                            minY = nY;
                        }
                    }
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

