import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int max = 100000;
    static int[] map = new int[max + 1];
    static int[] course = new int[max + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 일단 1 넣어줌
        map[N] = 1;

        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int idx = K;
        while (idx != N) {
            stack.push(course[idx]);
            idx = course[idx];
        }

        System.out.println(map[K] - 1);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        while (!q.isEmpty()) {
            int current = q.poll();

            if(current == K) return;

            // 앞으로 한 칸
            if(current + 1 <= max && map[current + 1] == 0){
                q.add(current + 1);
                map[current + 1] = map[current] + 1;
                course[current + 1] = current;
            }
            // 뒤로 한 칸
            if (current - 1 >= 0 && map[current - 1] == 0) {
                q.add(current - 1);
                map[current - 1] = map[current] + 1;
                course[current - 1] = current;
            }
            // 순간이동
            if (current * 2 <= max && map[current * 2] == 0) {
                q.add(current * 2);
                map[current * 2] = map[current] + 1;
                course[current * 2] = current;
            }
        }
    }
}
