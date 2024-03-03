import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1000 * 100 + 101;

    static class Node implements Comparable<Node> {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static int N, M, X, result;
    static int[] returnHome;

    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
        }
        returnHome = new int[N + 1];
        Arrays.fill(returnHome, INF);
        returnHome[X] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(X, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (returnHome[cur.idx] < cur.weight) {
                continue;
            }
            for (Node next : graph[cur.idx]) {
                int nextWeight = next.weight + returnHome[cur.idx];
                if (returnHome[next.idx] > nextWeight) {
                    returnHome[next.idx] = nextWeight;
                    queue.add(new Node(next.idx, nextWeight));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }
            dijkstra(i);
        }

        System.out.println(result);
    }

    private static void dijkstra(int start) {
        int[] visit = new int[N + 1];
        Arrays.fill(visit, INF);
        visit[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (visit[cur.idx] < cur.weight) {
                continue;
            }
            for (Node next : graph[cur.idx]) {
                int nextWeight = next.weight + visit[cur.idx];
                if (visit[next.idx] > nextWeight) {
                    visit[next.idx] = nextWeight;
                    queue.add(new Node(next.idx, nextWeight));
                }
            }
        }
        result = Math.max(result, visit[X] + returnHome[start]);
    }
}
