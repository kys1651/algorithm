import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        Deque<Integer> deque;
        StringTokenizer st;

        while (T-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");

            deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(command, deque);
        }
        System.out.println(sb);
    }

    private static void AC(String command, Deque<Integer> deque) throws IOException {
        boolean isRight = true;

        for (char ch : command.toCharArray()) {

            if (ch == 'R') {
                isRight = !isRight;
                continue;
            }

            // 뒤집어진 경우
            if (isRight) {

                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {

                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        sb.append("[");

        if (!deque.isEmpty()) {

            if (isRight) {

                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            } else {

                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }

        sb.append("]").append("\n");
    }
}
