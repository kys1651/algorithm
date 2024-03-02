import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int M, C, I;
    static int[] memory;
    static String command, input;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            I = Integer.parseInt(st.nextToken());
            command = br.readLine();
            map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == '[') {
                    stack.push(i);
                } else if (command.charAt(i) == ']') {
                    int idx = stack.pop();
                    map.put(idx, i);
                    map.put(i, idx);
                }
            }
            input = br.readLine();

            memory = new int[C];
            int pointer = 0;
            int commandPointer = 0;
            int inputPointer = 0;
            int count = 0;
            int prevIdx = 0;
            int curIdx = 0;
            boolean loop = false;
            while (true) {
                char commandChar = command.charAt(commandPointer);
                switch (commandChar) {
                    case '-':
                        memory[pointer]--;
                        if (memory[pointer] < 0) {
                            memory[pointer] = 255;
                        }
                        break;
                    case '+':
                        memory[pointer] = (memory[pointer] + 1) % (256);
                        break;
                    case '<':
                        pointer--;
                        if (pointer < 0) pointer = C - 1;
                        break;
                    case '>':
                        pointer = (pointer + 1) % C;
                        break;
                    case '[':
                        if (memory[pointer] == 0) {
                            commandPointer = map.get(commandPointer);
                        }
                        break;
                    case ']':
                        if (memory[pointer] != 0) {
                            commandPointer = map.get(commandPointer);
                        }
                        break;
                    case '.':
                        break;
                    case ',':
                        if (inputPointer == I) {
                            memory[pointer] = 255;
                        } else {
                            memory[pointer] = input.charAt(inputPointer++);
                        }
                        break;
                }

                commandPointer++;
                if (commandPointer == C) {
                    sb.append("Terminates").append('\n');
                    break;
                }

                count++;
                if (count > 50_000_000) {
                    curIdx = Math.max(curIdx, commandPointer);
                }
                if (count > 50_000_000 * 2) {
                    sb.append("Loops ").append(map.get(curIdx)).append(' ').append(curIdx).append('\n');
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
