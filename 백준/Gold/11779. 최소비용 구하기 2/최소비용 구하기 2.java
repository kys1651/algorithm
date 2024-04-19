import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
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
    static final int INF = 100_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        graph = new Node[N + 1];

        // Input
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from] = new Node(to, weight, graph[from]);
        }// Input End

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        boolean[] visit = new boolean[N + 1];
        int[] weight = new int[N + 1];
        Arrays.fill(weight, INF);
        weight[start] = 0;
        int[] prev = new int[N + 1];
        pq.add(new Node(start, 0, null));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visit[cur.idx]) continue;
            visit[cur.idx] = true;
            for (Node tmp = graph[cur.idx]; tmp != null; tmp = tmp.next) {
                if (weight[tmp.idx] > weight[cur.idx] + tmp.weight) {
                    weight[tmp.idx] = weight[cur.idx] + tmp.weight;
                    prev[tmp.idx] = cur.idx;
                    pq.add(new Node(tmp.idx, weight[tmp.idx], null));
                }
            }
        }
        sb.append(weight[end]).append('\n');

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int count = 1;
        while (prev[end] != 0) {
            stack.push(prev[end]);
            end = prev[end];
            count++;
        }
        sb.append(count).append('\n');
        while(!stack.isEmpty()) sb.append(stack.pop()).append(' ');
        System.out.println(sb);
    }
}
