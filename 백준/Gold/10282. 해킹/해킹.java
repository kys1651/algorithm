import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 10_000_001;

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

    static Node[] graph;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph = new Node[N + 1];
            cost = new int[N + 1];
            Arrays.fill(cost, INF);

            // Input
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph[from] = new Node(to, weight, graph[from]);
            } // Input End

            cost[C] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
            pq.offer(new Node(C, 0, null));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (cost[cur.idx] < cur.weight) {
                    continue;
                }
                for (Node tmp = graph[cur.idx]; tmp != null; tmp = tmp.next) {
                    if (cost[tmp.idx] > tmp.weight + cost[cur.idx]) {
                        cost[tmp.idx] = tmp.weight + cost[cur.idx];
                        pq.offer(new Node(tmp.idx, cost[tmp.idx], null));
                    }
                }
            }

            int count = 0, max = 0;
            for (int i = 1; i <= N; i++) {
                if(cost[i] != INF){
                    count++;
                    max = Math.max(max, cost[i]);
                }
            }
            sb.append(count).append(' ').append(max).append('\n');
        }
        
        System.out.println(sb);
    }
}