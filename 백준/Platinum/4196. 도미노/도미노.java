import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, idx, size;
    static boolean[] visit;
    static int[] parent, scc;
    static ArrayList<Integer>[] graph;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            init();

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
            }

            for (int i = 1; i <= N; i++) {
                if(parent[i] == 0) dfs(i);
            }


            boolean[] inDegree = new boolean[size];
            for (int i = 1; i <= N; i++) {
                ArrayList<Integer> nextList = graph[i];
                for(int next : nextList){
                    if(scc[i] != scc[next]) inDegree[scc[next]] = true;
                }
            }

            int count = 0;
            for (int i = 0; i < size; i++) {
                if(!inDegree[i]) count++;
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    private static int dfs(int cur) {
        parent[cur] = ++idx;
        stack.push(cur);

        int p = parent[cur];
        ArrayList<Integer> nextList = graph[cur];
        for (int next : nextList) {
            if(parent[next]==0) p = Math.min(p, dfs(next));
            else if(!visit[next]) p = Math.min(p, parent[next]);
        }

        if(p == parent[cur]){
            while(true){
                int t = stack.pop();
                visit[t] = true;
                scc[t] = size; // 같은 연결요소로 이어줌
                if(t == cur) break;
            }
            size++;
        }

        return p;
    }

    private static void init() {
        size = idx = 0;
        visit = new boolean[N + 1];
        parent = new int[N + 1];
        scc = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        stack = new Stack<>();
    }
}