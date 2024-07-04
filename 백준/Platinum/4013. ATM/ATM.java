import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph, sccGraph;
    static Stack<Integer> stack = new Stack<>();
    static int[] parent, sccValue, sccIdx, dp;
    static boolean[] visit;
    static int sccSize, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        sccIdx = new int[N + 1];
        visit = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // Edge Input
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }// Edge Input End

        getSccGraph(N, br);

        st = new StringTokenizer(br.readLine());
        int S = sccIdx[Integer.parseInt(st.nextToken())];
        int P = Integer.parseInt(st.nextToken());

        bfs(S);

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        while(P--> 0) answer = Math.max(answer, dp[sccIdx[Integer.parseInt(st.nextToken())]]);
        System.out.println(answer);
    }

    private static void getSccGraph(int N, BufferedReader br) throws IOException {
        for (int i = 1; i <= N; i++) {
            if (parent[i] == 0) dfs(i);
        }
        dp = new int[sccSize];
        sccValue = new int[sccSize];
        sccGraph = new ArrayList[sccSize];
        for (int i = 0; i < sccSize; i++) sccGraph[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            sccValue[sccIdx[i]] += Integer.parseInt(br.readLine());
            for (int next : graph[i]) {
                if (sccIdx[i] != sccIdx[next]) {
                    sccGraph[sccIdx[i]].add(sccIdx[next]);
                }
            }
        }
    }

    private static void bfs(int S) {
        Queue<Integer> queue = new LinkedList<>();
        dp[S] = sccValue[S];
        queue.add(S);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : sccGraph[cur]) {
                int nextWeight = dp[cur] + sccValue[next];
                if (dp[next] < nextWeight) {
                    dp[next] = nextWeight;
                    queue.add(next);
                }
            }
        }
    }

    private static int dfs(int cur) {
        parent[cur] = ++idx;
        stack.push(cur);
        int p = parent[cur];
        for (int next : graph[cur]) {
            if (parent[next] == 0) p = Math.min(p, dfs(next));
            else if (!visit[next]) p = Math.min(p, parent[next]);
        }
        if (p == parent[cur]) {
            while (true) {
                int t = stack.pop();
                visit[t] = true;
                sccIdx[t] = sccSize;
                if (cur == t) break;
            }
            sccSize++;
        }
        return p;
    }
}