import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int x = 0;
        Deque<Integer> deque = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            if (line.equals("push_front")) {
                x = Integer.parseInt(st.nextToken());
                deque.addFirst(x);
            } else if (line.equals("push_back")) {
                x = Integer.parseInt(st.nextToken());
                deque.addLast(x);
            } else if (line.equals("pop_front")) {
                sb.append(deque.isEmpty() ? -1 : deque.removeFirst()).append("\n");
            } else if (line.equals("pop_back")) {
                sb.append(deque.isEmpty() ? -1 : deque.removeLast()).append("\n");
            } else if (line.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (line.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (line.equals("front")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            } else if (line.equals("back")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}