import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class Node {
        int idx;
        Node next;

        public Node(int idx, Node next) {
            this.idx = idx;
            this.next = next;
        }
    }

    static int N, M;
    static Node[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // Input
            visit = new boolean[N + 1];
            graph = new Node[N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from] = new Node(to, graph[from]);
                graph[to] = new Node(from, graph[to]);
            } // Input End

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    dfs(i);
                    answer++;
                }
            }
            sb.append(String.format("#%d %d\n", tc, answer));
        }
        System.out.println(sb);
    }

    private static void dfs(int pos) {
        visit[pos] = true;
        for (Node tmp = graph[pos]; tmp != null; tmp = tmp.next) {
            if(!visit[tmp.idx]){
                dfs(tmp.idx);
            }
        }
    }
}
