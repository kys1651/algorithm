import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            stack.clear();

            for (char ch : str.toCharArray()) {
                if(ch == '(') stack.push(ch);
                else{
                    if(stack.isEmpty()){
                        stack.push(ch);
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            sb.append(stack.isEmpty()? "YES" : "NO").append("\n");
        }
        System.out.println(sb);

    }
}