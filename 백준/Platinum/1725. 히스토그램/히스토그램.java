import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long[] height = new long[N];
        long answer = 0;
        for (int i = 0; i < N; i++) {
            long h = Long.parseLong(br.readLine());
            height[i] = h;
            while (!stack.isEmpty() && height[stack.peek()] >= h) {
                long top = height[stack.pop()];
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();
                answer = Math.max(answer, width * top);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            long top = height[stack.pop()];
            long width = stack.isEmpty() ? N : N - 1 - stack.peek();
            answer = Math.max(answer, width * top);
        }
        System.out.println(answer);
    }
}