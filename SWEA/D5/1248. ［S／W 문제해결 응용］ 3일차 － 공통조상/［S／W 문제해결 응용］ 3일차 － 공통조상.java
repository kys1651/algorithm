import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
    static int v, e, node1, node2, commonAncestor;
    static int[][] graph;
    static int[] parents;
    static HashSet<Integer> ancestor;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            graph = new int[v + 1][2];
            parents = new int[v + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < e; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                if (graph[parent][0] == 0) {
                    graph[parent][0] = child;
                } else {
                    graph[parent][1] = child;
                }
                parents[child] = parent;
            }

            ancestor = new HashSet<>();
            searchAncestor(node1);
            searchAncestor(node2);
            int result = countSubTree(commonAncestor);
            sb.append("#" + tc + " " + commonAncestor + " " + result).append("\n");
        }
        System.out.println(sb);
    }

    private static int countSubTree(int node) {
        int left = graph[node][0];
        int right = graph[node][1];

        return 1 + (left == 0 ? 0 : countSubTree(left)) + (right == 0 ? 0 : countSubTree(right));
    }

    private static void searchAncestor(int node) {
        int pos = node;
        while (pos != 1) {
            if (ancestor.contains(parents[pos])) {
                commonAncestor = parents[pos];
                return;
            } else {
                ancestor.add(parents[pos]);
                pos = parents[pos];
            }
        }
    }

}