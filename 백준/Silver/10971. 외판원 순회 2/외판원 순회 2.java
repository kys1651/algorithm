import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result = Integer.MAX_VALUE;
    static int[][] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // Input
        visit = new boolean[N + 1];
        graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int weight = Integer.parseInt(st.nextToken());
                graph[i][j] = weight;
            }
        }// Input End

        visit[1] = true;
        dfs(1, 1, 0);
        System.out.println(result);
    }

    private static void dfs(int depth, int at, int cost) {
        if (depth == N) {
            if (graph[at][1] != 0) {
                result = Math.min(result, cost + graph[at][1]);
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (graph[at][i] == 0 || visit[i]) {
                continue;
            }
            visit[i] = true;
            dfs(depth + 1, i, cost + graph[at][i]);
            visit[i] = false;
        }
    }
}
