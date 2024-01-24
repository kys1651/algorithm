import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static class Frog{
        int pos;
        int count;

        public Frog(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }
    }
    static int n;
    static int[] bridge;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bridge = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(bfs(start, end));
    }

    private static int bfs(int start, int end) {
        boolean[] visit = new boolean[n + 1];
        visit[start] = true;

        Queue<Frog> queue = new LinkedList<>();
        queue.offer(new Frog(start, 0));

        while (!queue.isEmpty()) {
            Frog cur = queue.poll();
            if(cur.pos == end){
                return cur.count;
            }
            // 현재 위치에서 주어지는 정수 -> 배수만큼 갈 수 있음
            int jump = bridge[cur.pos];
            // 뒤로 가는 경우
            for (int i = cur.pos; i >= 1; i -= jump) {
                if (visit[i]) continue;
                visit[i] = true;
                queue.offer(new Frog(i, cur.count + 1));
            }

            // 앞으로 가는 경우
            for (int i = cur.pos; i <= n; i += jump) {
                if(visit[i]) continue;
                visit[i] = true;
                queue.offer(new Frog(i, cur.count + 1));
            }
        }

        return -1;
    }
}