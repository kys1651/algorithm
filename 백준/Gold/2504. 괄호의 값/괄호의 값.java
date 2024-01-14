import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        int tmp = 1;
        for (char c : text.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
                result.push(1);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    tmp = 2;
                    while (!result.isEmpty()) {
                        int value = result.pop();
                        if (value == 1) {
                            if(!result.isEmpty() && result.peek() != 1){
                                tmp += result.pop();
                            }
                            result.push(tmp);
                            break;
                        }
                        tmp *= value;
                    }
                }
                // 잘못된 경우
                else {
                    result.clear();
                    break;
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    tmp = 3;
                    while (!result.isEmpty()) {
                        int value = result.pop();
                        if (value == 1) {
                            if(!result.isEmpty() && result.peek() != 1){
                                tmp += result.pop();
                            }
                            result.push(tmp);
                            break;
                        }
                        tmp *= value;
                    }
                }
                // 잘못된 경우
                else {
                    result.clear();
                    break;
                }
            }
        }
        if (stack.isEmpty() && !result.isEmpty()) {
            System.out.println(result.pop());
        }else{
            System.out.println(0);
        }
    }
}