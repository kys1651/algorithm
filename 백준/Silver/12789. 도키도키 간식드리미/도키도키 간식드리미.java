import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int idx = 1;
        while (!queue.isEmpty()) {
            if (queue.peek() == idx) {
                queue.poll();
                idx++;
            } else if (!stack.isEmpty() && stack.peek() == idx) {
                stack.pop();
                idx++;
            } else {
                stack.push(queue.poll());
            }
        }
        while (!stack.isEmpty() && stack.peek() == idx) {
            stack.pop();
            idx++;
        }
        String result = stack.isEmpty() ? "Nice" : "Sad";
        System.out.println(result);
    }
}
