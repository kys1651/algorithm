import java.util.*;
import java.io.*;

public class Main {
    static final int SIZE = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> visit = new HashMap<>();
        // Input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            queue.add(idx);
            visit.put(idx, 0);
        }// Input End


        int[] dir = {-1, 1};
        while (visit.size() != (M + N)) {
            int cur = queue.poll();

            for (int i = 0; i < 2 && visit.size() != M + N; i++) {
                int nX = cur + dir[i];

                if (visit.getOrDefault(nX, SIZE * 2) <= visit.get(cur) + 1) continue;

                queue.add(nX);
                visit.put(nX, visit.get(cur) + 1);
            }
        }

        long answer = 0;
        for (int v : visit.values()) {
            answer += v;
        }
        System.out.println(answer);
    }
}