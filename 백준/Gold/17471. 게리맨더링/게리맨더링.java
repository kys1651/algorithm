import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    static int N, result = Integer.MAX_VALUE;
    static Node[] graph;
    static boolean[] visit;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // Input
        cost = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        graph = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int to = Integer.parseInt(st.nextToken());
                graph[i] = new Node(to, graph[i]);
            }
        } // Input End

        visit = new boolean[N + 1];
        solve(0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void solve(int depth) {
        if (depth == N) {
            isValid();
            return;
        }
        visit[depth] = true;
        solve(depth + 1);
        visit[depth] = false;
        solve(depth + 1);
    }

    private static void isValid() {
        boolean[] aCheck = new boolean[N + 1];
        boolean[] bCheck = new boolean[N + 1];
        int aSum = 0, bSum = 0, aStart = 0, bStart = 0;
        for (int i = 1; i <= N; i++) {
            if (visit[i]) {
                aSum += cost[i];
                aCheck[i] = true;
                aStart = i;
            } else {
                bSum += cost[i];
                bCheck[i] = true;
                bStart = i;
            }
        }

        if (aSum == 0 || bSum == 0) {
            return;
        }

        int gap = Math.abs(aSum - bSum);
        if (gap >= result) {
            return;
        }
        dfs(aStart, aCheck);
        dfs(bStart, bCheck);
        for (int i = 1; i <= N; i++) {
            if (aCheck[i] || bCheck[i]) {
                return;
            }
        }
        result = Math.min(result, gap);
    }

    private static void dfs(int pos, boolean[] check) {
        check[pos] = false;
        for (Node tmp = graph[pos]; tmp != null; tmp = tmp.next) {
            if (check[tmp.idx]) {
                dfs(tmp.idx, check);
            }
        }
    }
}
