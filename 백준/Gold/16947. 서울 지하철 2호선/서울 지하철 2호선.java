import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer>[] graph;
    static int[] dist;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        init();
        // Input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }// Input End

        for (int i = 1; i <= N; i++) {
            if(dfs(i, 0, i)) break;
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]).append(' ');
        }
        System.out.println(sb);
    }

    private static boolean dfs(int cur, int prev, int start) {
        dist[cur] = 0;
        
        for (int next : graph[cur]) {
            // 싸이클
            if (dist[next] == -1) {
                if (dfs(next, cur, start)) {
                    queue.add(cur);
                    return true;
                }
            } else if (next != prev && next == start) {
                queue.add(cur);
                return true;
            }
        }

        dist[cur] = -1;
        return false;
    }

    private static void init() {
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = -1;
        }
    }

}