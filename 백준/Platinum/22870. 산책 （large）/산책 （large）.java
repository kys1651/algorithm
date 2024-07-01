import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int idx;
        int weight;
        Node next;

        public Node(int idx, int weight, Node next) {
            this.idx = idx;
            this.weight = weight;
            this.next = next;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static Node[] graph;
    static int[] prev;
    static HashSet<Integer> visit = new HashSet<>();
    static int[] weight;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new Node[N + 1];
        prev = new int[N + 1];

        // Input
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, weight, graph[from]);
            graph[to] = new Node(from, weight, graph[to]);
        } // Input End

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        weight = new int[N + 1];
        Arrays.fill(weight, INF);
        Arrays.fill(prev, INF);
        dijkstra(end);

        int goDist = weight[start];

        Arrays.fill(weight, INF);
        int trace = start;
        while (trace != 0) {
            weight[trace] = -1;
//            System.out.println(trace);
            trace = prev[trace];
        }
        weight[start] = weight[end] = INF;
        Arrays.fill(prev, INF);

        dijkstra(start);
        int backDist = weight[end];
        System.out.println(goDist + backDist);
//
//        trace = end;
//        System.out.println("오는 길");
//        while (trace != 0) {
//            System.out.println(trace);
//            trace = prev[trace];
//        }
    }

    private static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0, null));
        weight[s] = 0;
        prev[s] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.weight < weight[cur.idx]) {
                continue;
            }
            for(Node tmp = graph[cur.idx]; tmp != null; tmp = tmp.next) {
                int nextWeight = cur.weight + tmp.weight;
                if (nextWeight < weight[tmp.idx] || (nextWeight == weight[tmp.idx] &&cur.idx < prev[tmp.idx])) {
                    prev[tmp.idx] = cur.idx;
                    weight[tmp.idx] = nextWeight;
                    pq.add(new Node(tmp.idx, nextWeight, null));
                }
            }
        }
    }
}