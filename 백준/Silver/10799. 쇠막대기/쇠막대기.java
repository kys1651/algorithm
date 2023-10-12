import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                continue;
            }

            // ch == ')'
            stack.pop();

            // 전 괄호가 열린 괄호일 경우(레이저를 의미함)
            if (input.charAt(i - 1) == '(') {
                // 현재 stack의 사이즈만큼 더해준다.(쇠막대기의 개수만큼 더해줌)
                result += stack.size();
            } else {
                // 그 전 괄호가 닫힌 괄호면 레이저가 아니기 때문에 단순히 1을 더해준다.
                result++;
            }
        }

        System.out.println(result);
    }
}