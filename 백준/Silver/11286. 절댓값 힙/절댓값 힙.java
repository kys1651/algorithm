import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2));
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                bw.write((pq.isEmpty() ? 0 : pq.poll()) + "\n");
            } else {
                pq.offer(x);
            }
        }
        bw.flush();
        bw.close();
    }
}
