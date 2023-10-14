import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Point> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Point cur = new Point(i, Integer.parseInt(st.nextToken()));

            while (!deque.isEmpty() && deque.peekLast().value > cur.value) {
                deque.removeLast();
            }
            deque.add(cur);

            if (deque.peekFirst().idx < i - L + 1) {
                deque.removeFirst();
            }

            bw.write(deque.peekFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Point {
        int idx;
        int value;

        Point(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

    }
}
