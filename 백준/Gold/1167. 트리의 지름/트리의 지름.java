import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visit;
    static int max, maxNodeIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) break;
                int value = Integer.parseInt(st.nextToken());
                graph[from].add(new Node(next, value));
            }
        }

        visit = new boolean[N+1];
        maxNodeIdx = 1;
        max = 0;
        dfs(maxNodeIdx, 0);

        visit = new boolean[N+1];
        dfs(maxNodeIdx, 0);

        System.out.println(max);
    }

    private static void dfs(int node, int cost) {
        visit[node] = true;
        if (cost > max) {
            max = cost;
            maxNodeIdx = node;
        }

        for (Node next : graph[node]) {
            if (visit[next.idx]) continue;
            dfs(next.idx, cost + next.value);
        }
    }
}