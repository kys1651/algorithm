import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        Node next;

        public Node(int idx, Node next) {
            this.idx = idx;
            this.next = next;
        }
    }

    static int N;
    static Node[] nodes;
    static int[][] dp;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];

        // 현재 얼리어답터가 아닌 경우 : 0
        // 현재 얼리어답터인 경우 : 1
        dp = new int[N + 1][2];
        nodes = new Node[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[from] = new Node(to, nodes[from]);
            nodes[to] = new Node(from, nodes[to]);
        }

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int cur) {
        visit[cur] = true;
        dp[cur][1] = 1;

        for (Node next = nodes[cur]; next != null; next = next.next) {
            if (visit[next.idx]) continue;
            dfs(next.idx);
            dp[cur][0] += dp[next.idx][1];

            if (dp[next.idx][0] > dp[next.idx][1]) {
                dp[cur][1] += dp[next.idx][1];
            } else {
                dp[cur][1] += dp[next.idx][0];
            }
        }
    }
}

