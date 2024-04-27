import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        Node next;

        public Node(int idx, Node next) {
            this.idx = idx;
            this.next = next;
        }
    }

    static Node[] graph;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        graph = new Node[N + 1];
        parent = new int[N + 1];

        // Input
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[p] = new Node(c, graph[p]);
            graph[c] = new Node(p, graph[c]);
        }// Input End

        dfs(1, 0);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean[] visit = new boolean[N + 1];
            while (a != 0) {
                visit[a] = true;
                a = parent[a];
            }
            while (!visit[b]) b = parent[b];
            sb.append(b).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int cur, int prev) {
        for (Node child = graph[cur]; child != null; child = child.next) {
            if (child.idx == prev) continue;

            parent[child.idx] = cur;
            dfs(child.idx, cur);
        }
    }
}
