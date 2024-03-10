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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[N + 1];
        int M = Integer.parseInt(br.readLine());

        // Input
        Queue<Password> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            visit[value] = true;
            queue.add(new Password(value, 0));
        }// Input End

        int max = 0;
        while (!queue.isEmpty()) {
            Password cur = queue.poll();
            max = cur.count;

            for (int i = 0; i < 20; i++) {
                int nextValue = cur.value ^ (1 << i);
                if (nextValue > N || visit[nextValue]) {
                    continue;
                }
                visit[nextValue] = true;
                queue.add(new Password(nextValue, max + 1));
            }
        }
        System.out.println(max);
    }
}
