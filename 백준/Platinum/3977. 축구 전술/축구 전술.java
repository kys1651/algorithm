import java.util.*;
import java.io.*;

public class Main {
    static final String CONFUSED = "Confused";
    static ArrayList<Integer>[] graph;
    static Stack<Integer> stack;
    static int[] sccIdx, parent;
    static boolean[] visit;
    static int idx, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            if (t != 0) br.readLine();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            init(N);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
            }

            SCC(N);
            int[] inDegree = getInDegree(N);

            int count = 0, start = 0;
            for (int i = 0; i < size; i++) {
                if (inDegree[i] == 0) {
                    count++;
                    start = i;
                }
            }

            if (count != 1) {
                sb.append(CONFUSED).append('\n');
            } else {
                for (int i = 0; i < N; i++) {
                    if (sccIdx[i] == start) {
                        sb.append(i).append('\n');
                    }
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int[] getInDegree(int N) {
        int[] inDegree = new int[size];
        for (int i = 0; i < N; i++) {
            for (int next : graph[i]) {
                if (sccIdx[i] != sccIdx[next]) {
                    inDegree[sccIdx[next]]++;
                }
            }
        }
        return inDegree;
    }

    private static void SCC(int N) {
        for (int i = 0; i < N; i++) {
            if (parent[i] == 0) dfs(i);
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
                sccIdx[t] = size;
                if (t == cur) break;
            }
            size++;
        }
        return p;
    }

    private static void init(int N) {
        idx = size = 0;
        parent = new int[N];
        sccIdx = new int[N];
        visit = new boolean[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        stack = new Stack<>();
    }
}