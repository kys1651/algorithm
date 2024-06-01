import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx;
        int distance;
        Node next;

        public Node(int idx, int distance, Node next) {
            this.idx = idx;
            this.distance = distance;
            this.next = next;
        }
    }

    static class Fox {
        int idx;
        int distance;

        public Fox(int next, int distance) {
            this.idx = next;
            this.distance = distance;
        }
    }

    static class Wolf {
        int idx;
        int distance;
        int speed;

        public Wolf(int idx, int distance, int speed) {
            this.idx = idx;
            this.distance = distance;
            this.speed = speed;
        }
    }

    static Node[] graph;
    static int[] fox;
    static int[][] wolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Input
        graph = new Node[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) * 2;

            graph[a] = new Node(b, d, graph[a]);
            graph[b] = new Node(a, d, graph[b]);
        }// Input End


        // 여우 거리 계산
        fox = new int[N + 1]; // 여우 거리 배열
        Arrays.fill(fox, Integer.MAX_VALUE);
        findFoxPath();


        // 늑대 거리 계산
        wolf = new int[2][N + 1];
        Arrays.fill(wolf[0], Integer.MAX_VALUE);
        Arrays.fill(wolf[1], Integer.MAX_VALUE);
        wolf[0][1] = 0;
        findWoldPath();


        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (fox[i] < Math.min(wolf[0][i], wolf[1][i])) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void findWoldPath(){
        PriorityQueue<Wolf> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        pq.add(new Wolf(1, 0, 0));

        while (!pq.isEmpty()) {
            Wolf cur = pq.poll();

            if (wolf[cur.speed][cur.idx] < cur.distance) continue;

            for (Node node = graph[cur.idx]; node != null; node = node.next) {
                int distance = node.distance;
                int nextSpeed = 0;

                // 천천히 가야한다면(nextSpeed = 0) 속도는 x 4
                if (cur.speed == 0) {
                    distance /= 2;
                    nextSpeed = 1;
                } else {
                    distance *= 2;
                }
                if (cur.distance + distance < wolf[nextSpeed][node.idx]) {
                    wolf[nextSpeed][node.idx] = cur.distance + distance;
                    pq.add(new Wolf(node.idx, wolf[nextSpeed][node.idx], nextSpeed));
                }
            }
        }
    }

    private static void findFoxPath() {
        PriorityQueue<Fox> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        pq.add(new Fox(1, 0));
        fox[1] = 0;

        while (!pq.isEmpty()) {
            Fox cur = pq.poll();

            // 현재 cur보다 더 짧은 거리가 갱신된 적 있다면 넘어간다.
            if (fox[cur.idx] < cur.distance) continue;

            for (Node node = graph[cur.idx]; node != null; node = node.next) {
                // 여우는 d * 2로 거리 계산
                if (cur.distance + node.distance < fox[node.idx]) {
                    fox[node.idx] = cur.distance + node.distance;
                    pq.add(new Fox(node.idx, fox[node.idx]));
                }
            }
        }
    }
}