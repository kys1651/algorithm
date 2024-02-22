import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }

            Stack<Integer> stack = new Stack<>();
            long[] height = new long[N];
            long answer = 0;
            for (int i = 0; i < N; i++) {
                long h = Long.parseLong(st.nextToken());
                height[i] = h;

                if (stack.isEmpty() || height[stack.peek()] < h) {
                    stack.push(i);
                    continue;
                }

                while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                    long top = height[stack.pop()];
                    long width = stack.isEmpty() ? i : i - 1 - stack.peek();
                    long tmp = top * width;
                    answer = Math.max(answer, tmp);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long top = height[stack.pop()];
                long width = stack.isEmpty() ? N : N - 1 - stack.peek();
                long tmp = top * width;
                answer = Math.max(tmp, answer);
            }

            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}