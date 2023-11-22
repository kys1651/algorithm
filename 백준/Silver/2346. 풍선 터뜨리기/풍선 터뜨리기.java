import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<int[]> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            deque.offer(new int[] {i, Integer.parseInt(st.nextToken())});
        }
        while (deque.size() != 1) {
            int[] ballon = deque.pollFirst();
            sb.append(ballon[0] + " ");
            int idx = ballon[1];
            if (idx > 0) {
                for (int i = 1; i < idx; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = idx; i != 0; i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        sb.append(deque.poll()[0]);
        System.out.println(sb.toString());
    }
}
