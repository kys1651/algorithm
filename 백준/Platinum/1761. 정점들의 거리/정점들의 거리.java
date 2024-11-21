import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class Weight {
        int idx;
        int cost;

        public Weight(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static int[][] parent;
    public static int[] cost;
    public static int[] depth;
    public static int N, maxDepth;
    public static ArrayList<Weight>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        init();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            tree[from].add(new Weight(to, cost));
            tree[to].add(new Weight(from, cost));
        }

        setTree(1, 1, 0, 0);
        fillParent();

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = getLCA(a, b);
            int result = cost[a] + cost[b] - (cost[lca] * 2);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    private static int getLCA(int a, int b) {
        int aH = depth[a];
        int bH = depth[b];
        if (aH < bH) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        for (int i = maxDepth - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[a][i];
            }
        }

        if (a == b) return a;

        for (int i = maxDepth - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }

    private static void fillParent() {
        for (int i = 1; i <= maxDepth; i++) {
            for (int j = 1; j <= N; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
    }

    private static void setTree(int cur, int depthSize, int prev, int sum) {
        cost[cur] = sum;
        depth[cur] = depthSize;
        for (Weight next : tree[cur]) {
            if (next.idx == prev) continue;
            parent[next.idx][0] = cur;
            setTree(next.idx, depthSize + 1, cur, sum + next.cost);
        }
    }

    private static void init() {
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        getMaxDepth(N);
        cost = new int[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1][maxDepth + 1];
    }

    private static void getMaxDepth(int n) {
        maxDepth = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
    }
}