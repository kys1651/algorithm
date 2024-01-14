import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        String command = br.readLine();
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Stack<Double> stack = new Stack<>();
        for (char c : command.toCharArray()) {
            // 숫자라면 알파벳으로 입력 받음
            if (Character.isAlphabetic(c)) {
                stack.push((double) num[c - 'A']);
            }else{
                double b = stack.pop();
                double a = stack.pop();
                double result = a + b;
                if(c == '-'){
                    result = a - b;
                } else if (c == '*') {
                    result = a * b;
                } else if (c == '/') {
                    result = a / b;
                }
                stack.push(result);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}