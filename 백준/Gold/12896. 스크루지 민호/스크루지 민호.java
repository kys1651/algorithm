import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int maxCount, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // Input
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }// Input End

        maxCount = -1;
        visit = new boolean[N + 1];
        dfs(1, 0);

        maxCount = -1;
        visit = new boolean[N + 1];
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
}