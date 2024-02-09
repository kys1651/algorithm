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
    static boolean[] isParent,visit;
    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        isParent = new boolean[N + 1];

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

            isParent[parent] = true;
        }

        if(tree[1].size() == 1){
            isParent[1] = false;
        }
        for (int i = 1; i <= N; i++) {
            if (isParent[i]) continue;

            visit = new boolean[N + 1];
            dfs(i, 0);
        }

        System.out.println(answer);
    }

    private static void dfs(int node, int cost) {
        if (!isParent[node] && cost != 0) {
            if(answer < cost) answer = cost;
            return;
        }

        visit[node] = true;
        for (Node next : tree[node]) {
            if(visit[next.idx]) continue;
            dfs(next.idx, cost + next.weight);
        }
    }
}