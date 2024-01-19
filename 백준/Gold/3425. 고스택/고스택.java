import java.util.*;
import java.io.*;

public class Main {
    static final String errorMsg = "ERROR";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            ArrayList<String> list = new ArrayList<>();
            // Input
            while(true){
                String command = br.readLine();
                if(command.equals("END")){
                    break;
                }else if(command.equals("QUIT")){
                    System.out.println(sb.toString().trim());
                    return;
                }else{
                    list.add(command);
                }
            }

            // Login
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                long v = Long.parseLong(br.readLine());
                sb.append(stackLogin(list,v) + "\n");
            }
            sb.append("\n");
            br.readLine();
        }
    }

    private static String stackLogin(ArrayList<String> list, long init) {
        Stack<Long> stack = new Stack<>();
        stack.push(init);

        for (String command : list) {
            if(command.startsWith("NUM")){
                int n = Integer.parseInt(command.split(" ")[1]);
                stack.push((long) n);
            } else if (command.equals("POP") && stack.size() >= 1) {
                stack.pop();
            } else if (command.equals("INV") && stack.size() >= 1) {
                stack.push(stack.pop() * -1L);
            } else if (command.equals("DUP") && stack.size() >= 1) {
                stack.push(stack.peek());
            } else if (command.equals("SWP") && stack.size() >= 2) {
                long a = stack.pop();
                long b = stack.pop();
                stack.push(a);
                stack.push(b);
            } else if (command.equals("ADD") && stack.size() >= 2) {
                long sum = stack.pop() + stack.pop();
                if (checkValue(Math.abs(sum))) {
                    return errorMsg;
                }
                stack.push(sum);
            } else if(command.equals("SUB") && stack.size() >= 2){
                long first = stack.pop();
                long second = stack.pop();
                if(checkValue(Math.abs(second - first))){
                    return errorMsg;
                }
                stack.push(second - first);
            } else if (command.equals("MUL") && stack.size() >= 2) {
                long first = stack.pop();
                long second = stack.pop();
                long sum = first * second;
                if (checkValue(sum)) {
                    return errorMsg;
                }
                stack.push(sum);
            } else if (command.equals("DIV") && stack.size() >= 2) {
                long first = stack.pop();
                long second = stack.pop();
                if(first == 0) {
                    return errorMsg;
                }
                long result = Math.abs(second) / Math.abs(first);
                if (first * second < 0) {
                    result *= -1L;
                }
                stack.push(result);
            } else if (command.equals("MOD") && stack.size() >= 2) {
                long first = stack.pop();
                long second = stack.pop();
                if(first == 0) {
                    return errorMsg;
                }
                long result = Math.abs(second) % Math.abs(first);
                if(second < 1){
                    result *= -1L;
                }
                stack.push(result);
            }else{
                return errorMsg;
            }
        }

        return stack.size() == 1 ? "" + stack.pop() : errorMsg;
    }

    private static boolean checkValue(long sum) {
        return Math.abs(sum) > Math.pow(10, 9);
    }
}
