import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point{
        int idx;
        int count;

        public Point(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }
    static int N,K;
    static int[] map = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map[N] = 1;

        bfs(new Point(N, 1));
    }

    private static void bfs(Point n) {
        Queue<Point> q = new LinkedList<>();
        q.add(n);

        // 앞 뒤 체크
        while (!q.isEmpty()) {
            Point tmp = q.poll();

            // 순간이동 경우
            if (2 * tmp.idx >= 0 && 2 * tmp.idx <= 100000) {
                if(map[2 * tmp.idx] == 0 || map[2 * tmp.idx] > tmp.count){
                    map[2 * tmp.idx] = tmp.count;
                    q.add(new Point(2 * tmp.idx, tmp.count));
                }
            }

            // 뒤로 한칸
            if (tmp.idx - 1 >= 0 && tmp.idx - 1 <= 100000) {
                if (map[tmp.idx - 1] == 0 || map[tmp.idx - 1] > tmp.count + 1) {
                    map[tmp.idx - 1] = tmp.count + 1;
                    q.add(new Point(tmp.idx - 1, tmp.count+1));
                }
            }

            // 앞으로 한칸
            if (tmp.idx + 1 >= 0 && tmp.idx + 1 <= 100000) {
                if (map[tmp.idx + 1] == 0 || map[tmp.idx + 1] > tmp.count + 1) {
                    map[tmp.idx + 1] = tmp.count + 1;
                    q.add(new Point(tmp.idx + 1, tmp.count + 1));
                }
            }




        }

        System.out.println(map[K]-1);
    }
}
