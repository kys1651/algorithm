import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] top = new int[n];

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            top[i] = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && top[stack.peek()] < top[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append('0');
            }else{
                sb.append(stack.peek() + 1);
            }
            sb.append(' ');
            stack.push(i);
        }

        System.out.println(sb);
    }
}
