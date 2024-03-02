import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int time; // 들어온 시간
        int life; // 생명력 수치
        int endTime;

        public Point(int x, int y, int time, int life) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.life = life;
            this.endTime = time + life;
        }

        @Override
        public int compareTo(Point o) {
            return endTime - o.endTime;
        }
    }

    static final int SIZE = 652;
    static int N, M, K;
    static PriorityQueue<Point> unActivatePoint;
    static PriorityQueue<Point> spreadPoint;
    static PriorityQueue<Point> activatePoint;
    static int[][] map;
    static int[][] timeStamp;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            unActivatePoint = new PriorityQueue<>();
            activatePoint = new PriorityQueue<>();
            spreadPoint = new PriorityQueue<>();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // Input
            timeStamp = new int[SIZE][SIZE];
            map = new int[SIZE][SIZE];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int x = 300 + i;
                    int y = 300 + j;
                    map[x][y] = Integer.parseInt(st.nextToken());
                    if (map[x][y] != 0) {
                        // 초기 상태는 0으로 넣어준다.
                        unActivatePoint.add(new Point(x, y, 0, map[x][y]));
                    }
                }
            }// Input End

            for (int i = 1; i <= K; i++) {
//                System.out.println(i);
//                print();
                bfs(i);
//                print();
//                System.out.println(unActivatePoint.size() + " " + activatePoint.size() + " " + spreadPoint.size());
            }

            sb.append(String.format("#%d %d\n", tc, unActivatePoint.size() + spreadPoint.size() + activatePoint.size()));
        }
        System.out.println(sb);
    }

    private static void print() {
        for (int i = 280; i < 330; i++) {
            for (int j = 280; j < 330; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void bfs(int time) {
        //  활성화해야하는 세포
        while (!unActivatePoint.isEmpty() && unActivatePoint.peek().endTime == time) {
            Point p = unActivatePoint.poll();

            p.time = time;
            p.endTime = time + 1;
            timeStamp[p.x][p.y] = -1;
            activatePoint.add(p);
        }

        Queue<Point> tmp = new LinkedList<>();
        while (!activatePoint.isEmpty() && activatePoint.peek().endTime == time) {
            Point p = activatePoint.poll();
            if (p.endTime == p.time + 1) {
                // 소멸 시점이 아니라면 갱신
                for (int i = 0; i < 4; i++) {
                    int nX = p.x + dirX[i];
                    int nY = p.y + dirY[i];

                    if (map[nX][nY] == -1) {
                        continue;
                    }

                    if (timeStamp[nX][nY] == 0 && map[nX][nY] == 0) {
                        timeStamp[nX][nY] = time;
                        map[nX][nY] = p.life;
                        tmp.add(new Point(nX, nY, time, p.life));
                    } else if (timeStamp[nX][nY] == time && map[nX][nY] < p.life) {
                        map[nX][nY] = p.life;
                        tmp.add(new Point(nX, nY, time, p.life));
                    }
                }
            }

            // 소멸 시점이 아니라면 다시 활성화 큐에 넣어줌
            if (p.endTime == p.time + p.life) {
                // 소멸 시점이면 지운다.
                map[p.x][p.y] = -1;
            } else {
                p.endTime = p.time + p.life;
                activatePoint.add(p);
            }
        }

        // 비활성화큐에 넣어준다.
        while (!tmp.isEmpty()) {
            Point p = tmp.poll();
            if (map[p.x][p.y] == p.life) {
                unActivatePoint.add(p);
            }
        }
    }
}
