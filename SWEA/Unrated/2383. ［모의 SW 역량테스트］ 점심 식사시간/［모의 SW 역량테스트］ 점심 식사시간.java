import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int K, result;
    static int[] match, len;
    static ArrayList<Point> people;
    static Point[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int idx = 0;
            K = 0;
            result = Integer.MAX_VALUE;
            people = new ArrayList<>();
            len = new int[2];
            stairs = new Point[2];

            // Input
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp == 1) {
                        people.add(new Point(i, j));
                        K++;
                    } else if (tmp != 0) {
                        len[idx] = tmp;
                        stairs[idx++] = new Point(i, j);
                    }
                }
            } // Input End

            match = new int[K];
            solve(0);
            sb.append(String.format("#%d %d\n", tc, result));
        }
        System.out.println(sb);
    }

    private static void solve(int depth) {
        if (depth == K) {
            simulation();
            return;
        }

        for (int i = 0; i < 2; i++) {
            match[depth] = i;
            solve(depth + 1);
        }
    }

    private static void simulation() {
        PriorityQueue<Integer> pq0 = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            if (match[i] == 0) {
                pq0.add(getDist(people.get(i), stairs[0]));
            } else {
                pq1.add(getDist(people.get(i), stairs[1]));
            }
        }

        int[] stair0 = new int[3];
        int[] stair1 = new int[3];
        int time = 0;
        int people = K;
        while (true) {
            if(time > result){
                return;
            }
            if (people == 0) {
                boolean exit = true;
                for (int i = 0; i < 3; i++) {
                    if (stair0[i] != 0 || stair1[i] != 0) {
                        exit = false;
                        break;
                    }
                }
                if (exit) break;
            }

            for (int i = 0; i < 3; i++) {
                // 현재 계단에 사람이 없으면
                if (stair0[i] == 0) {
                    if (!pq0.isEmpty()) {
                        if (pq0.peek() <= time) {
                            people--;
                            pq0.poll();
                            stair0[i] = len[0];
                        }
                    }
                } else {
                    stair0[i]--;
                    if (stair0[i] == 0) {
                        if (!pq0.isEmpty()) {
                            if (pq0.peek() <= time) {
                                people--;
                                pq0.poll();
                                stair0[i] = len[0];
                            }
                        }
                    }
                }

                if (stair1[i] == 0) {
                    if (!pq1.isEmpty()) {
                        if (pq1.peek() <= time) {
                            people--;
                            stair1[i] = len[1];
                            pq1.poll();
                        }
                    }
                } else {
                    stair1[i]--;
                    if (stair1[i] == 0) {
                        if (!pq1.isEmpty()) {
                            if (pq1.peek() <= time) {
                                people--;
                                stair1[i] = len[1];
                                pq1.poll();
                            }
                        }
                    }
                }
            }
            time++;
        }
        if (time < result){
            result = time;
        }
    }

    private static int getDist(Point people, Point stair) {
        return Math.abs(people.x - stair.x) + Math.abs(people.y - stair.y);
    }
}
