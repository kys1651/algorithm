import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static class BC {
        int x;
        int y;
        int c;
        int p;

        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }

    static int result;
    static int[] user1, user2;
    static BC[] BCs;
    static int[] C, P;

    static PriorityQueue<BC> user1PQ, user2PQ;


    // 0:이동 X, 1: 상, 2: 우, 3: 하, 좌:4
    static int[] dirX = {0, -1, 0, 1, 0};
    static int[] dirY = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            result = 0;
            setPQ();

            int[] user1Move = new int[M];
            user1 = new int[]{0, 0};
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                user1Move[i] = Integer.parseInt(st.nextToken());
            }

            int[] user2Move = new int[M];
            user2 = new int[]{9, 9};
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                user2Move[i] = Integer.parseInt(st.nextToken());
            }

            BCs = new BC[A];
            C = new int[A];
            P = new int[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                BCs[i] = new BC(x, y, c, p);
            }


//            System.out.println("초기 : ");
            getCharge();
            for (int i = 0; i < M; i++) {
                userMove(user1, user1Move[i]);
                userMove(user2, user2Move[i]);
//                System.out.println(i + 1 + " 초");
//                System.out.println("user1: " + user1[0] + " " + user1[1]);
//                System.out.println("user2: " + user2[0] + " " + user2[1]);
                getCharge();
            }

            sb.append('#').append(tc).append(' ').append(result).append('\n');
        }
        System.out.println(sb);
    }

    private static void getCharge() {
        user1PQ.clear();
        user2PQ.clear();
        for (BC b : BCs) {
            if (getDist(b, user1) <= b.c) {
                user1PQ.add(b);
            }
            if (getDist(b, user2) <= b.c) {
                user2PQ.add(b);
            }
        }

        BC bc1 = null;
        if (!user1PQ.isEmpty()) {
            bc1 = user1PQ.poll();
        }

        BC bc2 = null;
        if (!user2PQ.isEmpty()) {
            bc2 = user2PQ.poll();
        }

        if (bc1 == null && bc2 == null) {
//            System.out.println("충전 할 곳 없음");
            return;
        } else if (bc1 != null && bc2 == null) {
//            System.out.println("user1 충전: " + bc1.p);
            result += bc1.p;
        } else if (bc1 == null && bc2 != null) {
//            System.out.println("user2 충전: " + bc2.p);
            result += bc2.p;
        } else {
            // 같은 BC가 아니라면
            if (bc1 != bc2) {
//                System.out.println("user1 , user2 : " + bc1.p + " " + bc2.p);
                result += bc1.p + bc2.p;
            }
            // 같다면
            else {
                if (user1PQ.isEmpty() && user2PQ.isEmpty()) {
//                    System.out.println("나눠 먹음 : " + (bc1.p / 2));
                    result += (bc1.p / 2) * 2;
                } else if (user1PQ.isEmpty()) {
//                    System.out.println("user1, user2: " + bc1.p + " " + user2PQ.peek().p);
                    result += bc1.p + user2PQ.poll().p;
                } else if (user2PQ.isEmpty()) {
//                    System.out.println("user2, user1: " + bc2.p + " " + user1PQ.peek().p);
                    result += bc2.p + user1PQ.poll().p;
                } else {
                    int a = user1PQ.peek().p;
                    int b = user2PQ.peek().p;
//                    System.out.println(bc1.p + " " + Math.max(a, b));
                    result += bc1.p + Math.max(a, b);
                }
            }
        }
    }

    private static void setPQ() {
        user1PQ = new PriorityQueue<>((o1, o2) -> o2.p - o1.p);
        user2PQ = new PriorityQueue<>((o1, o2) -> o2.p - o1.p);
    }

    private static void userMove(int[] user, int dir) {
        user[0] += dirX[dir];
        user[1] += dirY[dir];
    }

    private static int getDist(BC a, int[] user) {
        return Math.abs(a.x - user[0]) + Math.abs(a.y - user[1]);
    }
}
