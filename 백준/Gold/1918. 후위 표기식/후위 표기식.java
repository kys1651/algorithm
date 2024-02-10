import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        Stack<Character> operator = new Stack<>();

        int len = input.length();
        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            
            // StringBuilder에 추가
            if (ch >= 'A' && ch <= 'Z') {
                sb.append(ch);
                continue;
            }
            // 스택이 비어있다면 push
            if (operator.isEmpty()) {
                operator.push(ch);
                continue;
            }

            // 여는 괄호(연산자 0순위) - 추가
            if (ch == '(') {
                operator.push(ch);
            } else if (ch == ')') {
                // 닫는 괄호(연산자 0순위) - 여는 괄호 만날 때 까지 sb에 추가
                while (operator.peek() != '(') {
                    sb.append(operator.pop());
                }
                operator.pop(); // 여는 괄호를 빼준다.
            }
            // *,/ (연산자 1순위) - *,/만 제거
            else if (ch == '*' || ch == '/') {
                // 곱하기 혹은 나누기를 만날 때까지 전부 제거함
                while (!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/')) {
                    sb.append(operator.pop());
                }
                // 현재 연산자를 스택에 삽입
                operator.push(ch);
            }
            // 더하기 혹은 빼기(연산자 최하위) - ( 제외하고 모두 추가해줘야함
            else if (ch == '+' || ch == '-') {
                // 여는 괄호가 아니면 전부 제거 함
                while (!operator.isEmpty() && (operator.peek() != '(')) {
                    sb.append(operator.pop());
                }
                operator.push(ch);
            }
        }

        // 남는 괄호가 있다면 Sb에 추가
        while (!operator.isEmpty()){
            sb.append(operator.pop());
        }

        System.out.println(sb);
    }
}