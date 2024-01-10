import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    // 그래프를 만들기 위한 노드 클래스
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }
    // 출력하는 시간을 줄이기 위한 StrignBuilder
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 처음 입력 받은 값은 무조건 루트 노드이다. -> 전위순회이기때문에
        Node root = new Node(Integer.parseInt(br.readLine()));

        String tmp;
        while (true) {
            // 입력 받은 값이 null이거나 비어있다면 EOF이므로 종료
            tmp = br.readLine();
            if (tmp == null || tmp.isEmpty()) {
                break;
            }
            // 노드 값 입력 받음
            int node = Integer.parseInt(tmp);
            // 루트부터 시작하여 현재 입력 값을 넣을 위치를 찾는다.
            // 즉 그래프를 먼저 만들어준다.
            Node pos = root;
            while (true) {
                // 값이 현재 값보다 작다면 왼쪽
                if (pos.value > node) {
                    // 만약 왼쪽 노드가 존재하지 않는다면 그 자리에 입력 값을 노드로 위치시킨다.
                    if (pos.left == null) {
                        pos.left = new Node(node);
                        break;
                    }
                    // 존재한다면 pos를 pos.left로 갱신한다.
                    else {
                        pos = pos.left;
                    }
                }
                // 현재 값보다 크다면 오른쪽
                else {
                    // 오른쪽 노드가 존재하지 않는다면 그 자리에 입력 값을 노드로 위치 시킨다.
                    if (pos.right == null) {
                        pos.right = new Node(node);
                        break;
                    }
                    // 존재한다면 pos를 pos.left로 갱신한다.
                    else {
                        pos = pos.right;
                    }
                }
            }
        }

        // 루트노드부터 시작
        LRV(root);
        System.out.println(sb);
    }

    //
    private static void LRV(Node node) {
        // 왼쪽 노드가 null이 아니라면(연결되어 있다면) 재귀 호출
        if (node.left != null) {
            LRV(node.left);
        }
        // 오른쪽 노드가 null이 아니라면(연결되어 있다면) 재귀 호출
        if (node.right != null) {
            LRV(node.right);
        }
        // 시간을 단축시키기 위해 현재 노드의 값을 출력하는 것이 아닌 StringBuilder에 넣어준다.
        sb.append(node.value).append("\n");
    }
}