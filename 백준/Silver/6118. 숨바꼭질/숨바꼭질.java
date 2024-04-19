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

    static Node[] graph;
    static final int INF = 20000 * 50000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Input
        graph = new Node[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, 1, graph[from]);
            graph[to] = new Node(from, 1, graph[to]);
        }// Input End

        int[] weight = new int[N + 1];
        Arrays.fill(weight, INF);
        weight[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Node(1, 0, null));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(weight[cur.idx] < cur.weight) continue;
            for (Node tmp = graph[cur.idx]; tmp != null; tmp = tmp.next) {
                if (weight[tmp.idx] > weight[cur.idx] + tmp.weight) {
                    weight[tmp.idx] = weight[cur.idx] + tmp.weight;
                    pq.add(new Node(tmp.idx, weight[tmp.idx], null));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int maxIdx=  0;
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if(weight[i] > max){
                max = weight[i];
                maxIdx = i;
                count = 0;
            }
            if (weight[i] == max) {
                count++;
            }
        }
        System.out.print(maxIdx + " ");
        System.out.print(max + " ");
        System.out.print(count);
    }
}
