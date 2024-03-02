import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;

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

    static int V, E;
    static int[] visit;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        visit = new int[V + 1];
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(visit, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        visit[start] = 0;
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (visit[cur.idx] < cur.weight) {
                continue;
            }
            for (Node next : graph[cur.idx]) {
                int nextWeight = visit[cur.idx] + next.weight;
                if (visit[next.idx] > nextWeight) {
                    visit[next.idx] = nextWeight;
                    queue.add(new Node(next.idx, nextWeight));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(visit[i] == INF ? "INF" : visit[i]).append('\n');
        }
        System.out.println(sb);
    }
}
