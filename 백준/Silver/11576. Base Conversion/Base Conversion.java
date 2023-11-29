import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int num = 0;
        for (int i = m - 1; i >= 0; i--) {
            int tmp = Integer.parseInt(st.nextToken());
            num += tmp * (int)Math.pow(a, i);
        }
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            stack.push(num % b);
            num /= b;
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop() + " " );
        }
        System.out.println(sb);
    }

}