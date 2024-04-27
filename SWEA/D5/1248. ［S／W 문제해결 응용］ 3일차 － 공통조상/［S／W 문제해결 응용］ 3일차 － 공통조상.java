import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static class Node {
        int idx;
        Node next;

        public Node(int idx, Node next) {
            this.idx = idx;
            this.next = next;
        }
    }

    static Node[] tree;
    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // Input
            tree = new Node[V + 1];
            size = new int[V + 1];
            parent = new int[V + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                tree[p] = new Node(c, tree[p]);
            }// Input End

            dfs(1);

            HashSet<Integer> set = new HashSet<>();
            while (A != 0) {
                set.add(A);
                A = parent[A];
            }
            while (!set.contains(B)) {
                B = parent[B];
            }
            sb.append(String.format("#%d %d %d\n", tc, B, size[B]));
        }
        System.out.println(sb);
    }

    private static void dfs(int cur) {
        size[cur] = 1;

        for (Node child = tree[cur]; child != null; child = child.next) {
            parent[child.idx] = cur;
            dfs(child.idx);
            size[cur] += size[child.idx];
        }
    }
}
