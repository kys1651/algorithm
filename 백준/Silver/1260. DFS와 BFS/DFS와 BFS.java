import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // input
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visit = new boolean[N + 1];
        dfs(V);
        sb.append('\n');

        visit = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visit[v] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(' ');
            for (int next : graph[cur]) {
                if (visit[next]) continue;
                visit[next] = true;
                queue.add(next);
            }
        }
    }

    private static void dfs(int node) {
        sb.append(node).append(' ');

        visit[node] = true;
        for (int next : graph[node]) {
            if (visit[next]) continue;
            dfs(next);
        }
    }

}