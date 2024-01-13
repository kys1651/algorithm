import java.io.*;
import java.util.*;

class Main {
    static class Node {
        char value;
        // left, right는 null로 초기화 됨
        Node left, right;

        Node(char idx) {
            this.value = idx;
        }

        // 노드를 집어넣는 insert 메서드
        // 임시로 만든 뒤 현재 노드에서 비교한다.
        void insert(Node node) {
            // 현재 value와 입력 받은 value가 같다면 입력받은 노드의 왼쪽 자식 노드와 오른쪽 자식노드를 이어받는다.
            if (this.value == node.value) {
                left = node.left;
                right = node.right;
            }
            // 값이 다르다면 오른쪽과 왼쪽을 다 확인해야함.
            // 이진 트리이고 다른 조건은 존재하지 않기 때문에
            else {
                if (left != null) {
                    left.insert(node);
                }
                if (right != null) {
                    right.insert(node);
                }
            }
        }
    }

    // 순회하는데에 출력을 저장하기 위한 StringBuilder
    static StringBuilder sb;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        // root 노드는 무조건 A이다.
        Node root = new Node('A');

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            // 일단 임시로 노드를 만들어준다.
            Node tmp = new Node(node);
            if (left != '.') {
                tmp.left = new Node(left);
            }
            if (right != '.') {
                tmp.right = new Node(right);
            }
            // 임시 노드를 root를 기준으로 삽입하여준다.
            root.insert(tmp);
        }
        // 전위순회 -> (V)(LEFT)(RIGHT)
        VLR(root);
        sb.append("\n");
        // 중위순회 -> (LEFT)(V)(RIGHT)
        LVR(root);
        sb.append("\n");
        // 후위순회 -> (LEFT)(RIGHT)(V)
        LRV(root);
        System.out.println(sb);
    }

    // VLR -> ROOT,LEFT,RIGHT
    private static void VLR(Node root) {
        sb.append(root.value);
        if (root.left != null) {
            VLR(root.left);
        }
        if (root.right != null) {
            VLR(root.right);
        }
    }

    // LVR -> LEFT, ROOT, RIGHT
    private static void LVR(Node root) {
        if (root.left != null) {
            LVR(root.left);
        }
        sb.append(root.value);
        if (root.right != null) {
            LVR(root.right);
        }
    }

    // LRV -> LEFT, RIGHT, ROOT
    private static void LRV(Node root) {
        if (root.left != null) {
            LRV(root.left);
        }
        if (root.right != null) {
            LRV(root.right);
        }
        sb.append(root.value);
    }
}