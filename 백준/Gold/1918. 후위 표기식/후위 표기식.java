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

        for (char ch : input.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                sb.append(ch);
            }else if(ch == '('){
                operator.push(ch);
            } else if (ch == ')') {
                // 여는 괄호 만날 때 까지 Sb에 추가
                while (!operator.isEmpty() && operator.peek() != '(') {
                    sb.append(operator.pop());
                }
                // 여는 괄호를 빼준다.
                operator.pop();
            } else if (ch == '*' || ch == '/') {
                // 곱하기 혹은 나누기를 만날 때까지 전부 제거함
                while (!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/')) {
                    sb.append(operator.pop());
                }
                // 현재 연산자를 스택에 삽입
                operator.push(ch);
            }
            // 더하기 혹은 빼기일 경우
            else if (ch == '+' || ch == '-') {
                // 여는 괄호가 아니면 전부 제거 함
                while(!operator.isEmpty() && (operator.peek() != '(')){
                    sb.append(operator.pop());
                }
                operator.push(ch);
            }
        }


        while (!operator.isEmpty()){
            sb.append(operator.pop());
        }
        System.out.println(sb);
    }
}