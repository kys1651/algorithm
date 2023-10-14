import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.getLast().value > tmp) {
                deque.removeLast();
            }

            deque.addLast(new Node(i, tmp));

            if (deque.getFirst().idx <= i - L) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }


    static class Node {
        public int idx;
        public int value;

        Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
