import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visit;
    static int maxCount, max, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        visit = new boolean[N + 1];
        init();

        StringTokenizer st;

        // Input
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }// Input End

        dfs(1, 0);

        visit = new boolean[N + 1];
        maxCount = -1;
        dfs(max, 0);

        System.out.println((maxCount + 1) / 2);
    }

    private static void dfs(int cur, int count) {
        if (count > maxCount) {
            maxCount = count;
            max = cur;
        }
        
        visit[cur] = true;

        for (int next : graph[cur]) {
            if (visit[next]) continue;
            dfs(next, count + 1);
        }
    }


    private static void init() {
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
    }
}