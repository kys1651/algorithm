import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static ArrayList<Node>[] tree;
    static boolean[] visit;
    static int N, max, maxNode = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 생성
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }
        visit = new boolean[N + 1];
        visit[1] = true;
        dfs(1, 0);

        visit = new boolean[N + 1];
        visit[maxNode] = true;
        dfs(maxNode, 0);

        System.out.println(max);
    }

    private static void dfs(int node, int cost) {
        if (max < cost) {
            max = cost;
            maxNode = node;
        }

        for (Node next : tree[node]) {
            if (visit[next.idx]) continue;
            visit[next.idx] = true;
            dfs(next.idx, cost + next.weight);
        }
    }
}