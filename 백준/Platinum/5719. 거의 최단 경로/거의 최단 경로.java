import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        int weight;
        Node next;

        public Node(int idx, int weight, Node next) {
            this.idx = idx;
            this.weight = weight;
            this.next = next;
        }
    }

    static final int INF = 500_001;
    static Node[] graph;
    static Node[] connect;
    static boolean[][] visit;
    static int[] weight;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // Input
            graph = new Node[N];
            connect = new Node[N];
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                graph[U] = new Node(V, P, graph[U]);
            } // Input End

            visit = new boolean[N][N];
            weight = new int[N];
            Arrays.fill(weight, INF);
            dijkstra(S, E);
            erasePath(S, E);

            Arrays.fill(weight, INF);
            weight[S] = weight[E] = INF;
            dijkstra(S, E);

            sb.append(weight[E] == INF ? -1 : weight[E]).append('\n');
        }
        System.out.println(sb);
    }

    private static void erasePath(int s, int e) {
        if(s == e) return;
        for (Node tmp = connect[e]; tmp != null; tmp = tmp.next) {
            if(!visit[tmp.idx][e]){
                visit[tmp.idx][e] = true;
                erasePath(s, tmp.idx);
            }
        }
    }

    private static void dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Node(s, 0, null));
        weight[s] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.weight > weight[cur.idx]) continue;
            for (Node tmp = graph[cur.idx]; tmp != null; tmp = tmp.next) {
                if (visit[cur.idx][tmp.idx]) continue;
                int nextWeight = cur.weight + tmp.weight;
                if (nextWeight < weight[tmp.idx]) {
                    connect[tmp.idx] = new Node(cur.idx, 0, null);
                    weight[tmp.idx] = nextWeight;
                    pq.add(new Node(tmp.idx, nextWeight, null));
                } else if (nextWeight == weight[tmp.idx]) {
                    connect[tmp.idx] = new Node(cur.idx, 0, connect[tmp.idx]);
                }
            }
        }
    }
}