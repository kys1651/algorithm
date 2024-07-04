import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, idx, sccCount;
    static int[] parent;
    static boolean[] visit;
    static ArrayList<Integer>[] graph;
    static ArrayList<PriorityQueue<Integer>> answer = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }

        for (int i = 1; i <= N; i++) {
            if(parent[i] == 0) dfs(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sccCount).append('\n');
        Collections.sort(answer, (o1, o2) -> o1.peek() - o2.peek());
        for (PriorityQueue<Integer> q : answer) {
            while(!q.isEmpty()) sb.append(q.poll()).append(' ');
            sb.append("-1\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int cur) {
        parent[cur] = ++idx;
        stack.push(cur);

        int p = parent[cur];
        ArrayList<Integer> nextList = graph[cur];
        for(int next : nextList){
            if(parent[next] == 0) p = Math.min(p, dfs(next));
            else if(!visit[next]) p = Math.min(p, parent[next]);
        }

        if(p == parent[cur]){
            PriorityQueue<Integer> q = new PriorityQueue<>();
            while(true){
                int t = stack.pop();
                q.add(t);
                visit[t] = true;
                if(t == cur) break;
            }
            answer.add(q);
            sccCount++;
        }
        return p;
    }
}