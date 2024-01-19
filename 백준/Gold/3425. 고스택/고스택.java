import java.util.*;
import java.io.*;

public class Main {
    static final String errorMsg = "ERROR";
    static Stack<Long> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            // 명령어를 저장하기 위한 배열
            ArrayList<String> commandList = new ArrayList<>();
            // 스택 초기화

            // Input
            while (true) {
                String command = br.readLine();
                // END가 나오면 명령어 입력 종료
                if (command.equals("END")) {
                    break;
                }
                // QUIT가 나오면 프로그램 종료
                else if (command.equals("QUIT")) {
                    System.out.println(sb.toString().trim());
                    return;
                }
                // 그 외에는 전부 넣어준다.
                else {
                    commandList.add(command);
                }
            }

            // n만큼 수행횟수 실행
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                long v = Long.parseLong(br.readLine());
                sb.append(commandActivate(commandList, v) + "\n");
            }
            sb.append("\n");

            // 명령어 구분을 위한 빈줄 읽기
            br.readLine();
        }
    }

    // 초기값과 명령어 리스트를 받아서 매핑시켜주는 메소드
    private static String commandActivate(ArrayList<String> list, long init) {
        stack = new Stack<>();
        stack.push(init);

        for (String command : list) {
            if (command.startsWith("NUM") && num(Long.parseLong(command.split(" ")[1]))) {
            } else if (command.equals("POP") && pop()) {
            } else if (command.equals("INV") && inv()) {
            } else if (command.equals("DUP") && dup()) {
            } else if (command.equals("SWP") && swp()) {
            } else if (command.equals("ADD") && add()) {
            } else if (command.equals("SUB") && sub()) {
            } else if (command.equals("MUL") && mul()) {
            } else if (command.equals("DIV") && div()) {
            } else if (command.equals("MOD") && mod()) {
            }
            // 위에서 false가 발생했다면 "ERROR"
            else {
                return errorMsg;
            }
        }

        // 수행이 종료한 뒤 스택에 저장되어 있는 숫자가 1개가 아니라면 "ERROR"
        return stack.size() == 1 ? "" + stack.pop() : errorMsg;
    }


    // NUM X
    private static boolean num(long x) {
        stack.push(x);
        return true;
    }

    // POP
    private static boolean pop() {
        if (stack.size() >= 1) {
            stack.pop();
            return true;
        }
        return false;
    }

    // INV
    private static boolean inv() {
        if (stack.size() >= 1) {
            stack.push(stack.pop() * -1L);
            return true;
        }
        return false;
    }

    // DUP
    private static boolean dup() {
        if (stack.size() >= 1) {
            stack.push(stack.peek());
            return true;
        }
        return false;
    }

    // SWP
    private static boolean swp() {
        if (stack.size() >= 2) {
            long first = stack.pop();
            long second = stack.pop();
            stack.push(first);
            stack.push(second);
            return true;
        }
        return false;
    }

    // ADD
    private static boolean add() {
        if (stack.size() >= 2) {
            long sum = stack.pop() + stack.pop();
            if (!checkValue(Math.abs(sum))) {
                stack.push(sum);
                return true;
            }
        }
        return false;
    }

    // SUB
    private static boolean sub() {
        if (stack.size() >= 2) {
            long first = stack.pop();
            long second = stack.pop();
            long result = second - first;
            if (!checkValue(result)) {
                stack.push(result);
                return true;
            }
        }
        return false;
    }

    // MUL
    private static boolean mul() {
        if (stack.size() >= 2) {
            long result = stack.pop() * stack.pop();
            if (!checkValue(result)) {
                stack.push(result);
                return true;
            }
        }
        return false;
    }

    // DIV
    private static boolean div() {
        if (stack.size() >= 2) {
            long first = stack.pop();
            long second = stack.pop();
            if (first != 0) {
                long result = Math.abs(second) / Math.abs(first);
                if (first * second < 0) {
                    result *= -1L;
                }
                stack.push(result);
                return true;
            }
        }
        return false;
    }

    // MOD
    private static boolean mod() {
        if (stack.size() >= 2) {
            long first = stack.pop();
            long second = stack.pop();
            if (first != 0) {
                long result = Math.abs(second) % Math.abs(first);
                if (second < 1) result *= -1L;
                stack.push(result);
                return true;
            }
        }
        return false;
    }


    private static boolean checkValue(long sum) {
        return Math.abs(sum) > Math.pow(10, 9);
    }
}
