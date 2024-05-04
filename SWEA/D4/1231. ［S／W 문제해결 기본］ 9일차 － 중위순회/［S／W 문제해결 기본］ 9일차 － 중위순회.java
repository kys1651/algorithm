import java.util.*;
import java.io.*;

public class Solution {
    static class Node {
        int left, right;
        char value;

        public Node(int left, int right, char value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    static Node[] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            tree = new Node[N + 1];

            // Input
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                char value = st.nextToken().charAt(0);
                int left = 0, right = 0;
                if (st.hasMoreTokens()) {
                    left = Integer.parseInt(st.nextToken());
                }
                if (st.hasMoreTokens()) {
                    right = Integer.parseInt(st.nextToken());
                }
                tree[idx] = new Node(left, right, value);
            }// Input End

            sb = new StringBuilder();
            dfs(1);
            answer.append('#').append(tc).append(' ');
            answer.append(sb.toString()).append('\n');
        }
        System.out.println(answer);
    }

    private static void dfs(int V) {
        Node node = tree[V];
        if (node.left != 0) {
            dfs(node.left);
        }
        sb.append(node.value);
        if (node.right != 0) {
            dfs(node.right);
        }
    }
}

