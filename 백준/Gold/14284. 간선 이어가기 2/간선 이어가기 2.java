import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int idx;
        int weight;
        Node next;

        public Node(int idx, int weight, Node next) {
            this.idx = idx;
            this.weight = weight;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Input
        Node[] graph = new Node[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a] = new Node(b, c, graph[a]);
            graph[b] = new Node(a, c, graph[b]);
        } // Input End

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] cost = new int[N + 1];
        Arrays.fill(cost, 500_001);

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, 0, null));
        cost[s] = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cost[cur.idx] < cur.weight) {
                continue;
            }
            for (Node tmp = graph[cur.idx]; tmp != null; tmp = tmp.next) {
                if (cost[tmp.idx] > tmp.weight + cost[cur.idx]) {
                    cost[tmp.idx] = tmp.weight + cost[cur.idx];
                    q.add(new Node(tmp.idx, cost[tmp.idx], null));
                }
            }
        }

        System.out.println(cost[e]);
    }
}