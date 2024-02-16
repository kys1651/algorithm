import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];

        // 현재 얼리어답터가 아닌 경우 : 0
        // 현재 얼리어답터인 경우 : 1
        dp = new int[N + 1][2];
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tree[from].add(to);
            tree[to].add(from);
        }

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int cur) {
        visit[cur] = true;
        dp[cur][1] = 1;

        for (int next : tree[cur]) {
            if (visit[next]) continue;
            dfs(next);
            dp[cur][0] += dp[next][1];
            dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}

