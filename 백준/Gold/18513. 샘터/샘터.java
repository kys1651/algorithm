import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int idx;
        int count;

        public Point(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }

    static Set<Integer> visit = new HashSet<>();
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            visit.add(idx);
            queue.add(new Point(idx, 0));
        }// Input End

        System.out.println(solve(M));
    }

    private static long solve(int count) {
        long answer = 0;

        int[] dir = {-1, 1};
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i <= 1; i++) {
                int nX = cur.idx + dir[i];
                if(!visit.contains(nX)) {
                    queue.add(new Point(nX, cur.count + 1));
                    visit.add(nX);
                    count--;
                    answer += cur.count + 1;
                    if(count == 0) return answer;
                }
            }
        }

        return answer;
    }
}