import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        Node next;

        public Node(int idx) {
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Input
        String[] univ = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            univ[i] = br.readLine();
        }// Input End

        // Init
        Node[] head = new Node[N + 1];
        Node[] tail = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            head[i] = tail[i] = new Node(i);
        }// Init End

        StringTokenizer st;
        int endIdx = 0;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            tail[to].next = head[from];
            tail[to] = tail[from];

            if (i == N - 1) endIdx = to;
        }

        StringBuilder sb = new StringBuilder();
        for (Node node = head[endIdx]; node != null; node = node.next) {
            sb.append(univ[node.idx]);
        }
        System.out.println(sb);
    }
}