import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String tmp;
        while (true) {
            tmp = br.readLine();
            if (tmp.equals(".")) {
                break;
            }
            sb.append(solution(tmp)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String solution(String tmp) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < tmp.length(); i++) {
            char ch = tmp.charAt(i);

            if(ch == '('||ch=='['){
                stack.push(ch);
            }

            if(ch == ')'){

                if(stack.isEmpty()||stack.peek()!='(')
                    return "no";
                else
                    stack.pop();
            }

            if (ch == ']') {

                if(stack.isEmpty() || stack.peek() != '[')
                    return "no";
                else
                    stack.pop();
            }
        }
        if(stack.isEmpty()) return "yes";
        else return "no";
    }
}
