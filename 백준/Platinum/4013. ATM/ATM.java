import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, idx, size;
    static int[] parent, sccIdx, dp, value, restaurant;
    static boolean[] visit;
    static ArrayList<Integer>[] graph, sccList;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        visit = new boolean[N + 1];
        parent = new int[N + 1];

        sccIdx = new int[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
        }

        for (int i = 1; i <= N; i++) {
            if (parent[i] == 0) dfs(i);
        }


        dp = new int[size];
        value = new int[size];
        sccList = new ArrayList[size];
        for (int i = 0; i < size; i++) sccList[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            // 싸이클 인덱스에 더해줌
            value[sccIdx[i]] += Integer.parseInt(br.readLine());

            // 연결되는 싸이클에 넣어줘서 새로운 노드 생성
            for (int next : graph[i]) {
                if (sccIdx[i] != sccIdx[next]) {
                    sccList[sccIdx[i]].add(sccIdx[next]);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        restaurant = new int[p];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p; i++) restaurant[i] = Integer.parseInt(st.nextToken());

        bfs(sccIdx[S]);

        int max = 0;
        for (int i = 0; i < p; i++) {
            int idx = sccIdx[restaurant[i]];
            max = Math.max(dp[idx], max);
        }
        System.out.println(max);
    }

    private static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        dp[s] = value[s];

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : sccList[cur]) {
                int nextWeight = dp[cur] + value[next];
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
            if(parent[next] == 0) p = Math.min(p, dfs(next));
            else if(!visit[next]) p = Math.min(p, parent[next]);
        }

        if (p == parent[cur]) {
            while(true){
                int t = stack.pop();
                visit[t] = true;
                sccIdx[t] = size;
                if(t == cur) break;
            }
            size++;
        }
        return p;
    }
}