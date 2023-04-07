import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        Stack<Character> LStack = new Stack<>();
        Stack<Character> RStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            LStack.push(str.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.equals("L")) {
                if(!LStack.isEmpty()){
                    RStack.push(LStack.pop());
                }
            }
            else if (command.equals("D")) {
                if(!RStack.isEmpty()){
                    LStack.push(RStack.pop());
                }
            }
            else if (command.equals("B")) {
                // 왼쪽 글자 한개를 지우기
                if (!LStack.isEmpty()) {
                    LStack.pop();
                }
            }
            else if (command.contains("P")) {
                // 왼쪽에 글자를 추가 해주는 함수
                char ch = command.charAt(2);
                LStack.push(ch);
            }
        }

        while (!LStack.isEmpty()) {
            RStack.push(LStack.pop());
        }
        while (!RStack.isEmpty()) {
            sb.append(RStack.pop());
        }
        System.out.println(sb);
    }
}