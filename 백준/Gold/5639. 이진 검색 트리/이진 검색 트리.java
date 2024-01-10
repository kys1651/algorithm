import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        String tmp;
        while (true) {
            tmp = br.readLine();
            if (tmp == null || tmp.isEmpty()) {
                break;
            }
            int node = Integer.parseInt(tmp);
            Node pos = root;
            while (true) {
                // 값이 현재 값보다 작다면 왼쪽
                if (pos.value > node) {
                    if (pos.left == null) {
                        pos.left = new Node(node);
                        break;
                    } else {
                        pos = pos.left;
                    }
                }
                // 현재 값보다 크다면 오른쪽
                else {
                    if (pos.right == null) {
                        pos.right = new Node(node);
                        break;
                    } else {
                        pos = pos.right;
                    }
                }
            }
        }
        LRV(root);
        System.out.println(sb);
    }

    private static void LRV(Node node) {
        if (node.left != null) {
            LRV(node.left);
        }
        if (node.right != null) {
            LRV(node.right);
        }
        sb.append(node.value).append("\n");
    }
}