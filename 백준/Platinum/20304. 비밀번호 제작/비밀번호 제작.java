import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Password {
        int value;
        int count;

        public Password(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    static boolean[] visit = new boolean[1_000_001];
    static Queue<Password> queue = new LinkedList<>();
    static int N, maxSafe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            visit[value] = true;
            queue.add(new Password(value, 0));
        }// Input End

        bfs();
        System.out.println(maxSafe);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Password curPassword = queue.poll();
            if (curPassword.count > maxSafe) {
                maxSafe = curPassword.count;
            }

            for (int i = 0; i < 20; i++) {
                int nextValue = curPassword.value ^ (1 << i);
                if (nextValue > N || visit[nextValue]) {
                    continue;
                }
                visit[nextValue] = true;
                queue.add(new Password(nextValue, curPassword.count + 1));
            }
        }
    }
}
