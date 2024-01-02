import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            String line = br.readLine();
            Stack<Character> operator = new Stack<>();
            Stack<Integer> num = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                // 숫자인 경우 곱셈이라면 바로 곱해줌 아니면 스택에 넣는다.
                if (Character.isDigit(ch)) {
                    if (!operator.isEmpty() && operator.peek() == '*') {
                        num.push(num.pop() * (ch - '0'));
                        operator.pop();
                    } else {
                        num.push(ch - '0');
                    }
                }
                // 연산인 경우
                else {
                    // +가 두개면 숫자 두개를 pop해서 더해준뒤 다시 Push
                    if (ch == '+' && !operator.isEmpty() && operator.peek() == '+') {
                        num.push(num.pop() + num.pop());
                    } else {
                        operator.push(ch);
                    }
                }
            }
            int result = num.pop();
            if(!operator.isEmpty()){
                result += num.pop();
            }
            sb.append("#" + tc + " " + result).append("\n");
        }
        System.out.println(sb);
    }
}