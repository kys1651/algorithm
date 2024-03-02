import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int Sm, Sc, Si;
    static byte[] memory;
    static char[] code, input;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Sm = Integer.parseInt(st.nextToken());
            Sc = Integer.parseInt(st.nextToken());
            Si = Integer.parseInt(st.nextToken());
            memory = new byte[Sm];

            code = new char[Sc];
            input = new char[Si];
            map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();

            // Input
            String s = br.readLine();
            for (int i = 0; i < Sc; i++) {
                code[i] = s.charAt(i);
                if (s.charAt(i) == '[') {
                    stack.push(i);
                } else if (s.charAt(i) == ']') {
                    int idx = stack.pop();
                    map.put(idx, i);
                    map.put(i, idx);
                }
            }// Input End
            input = br.readLine().toCharArray();

            int pointer = 0;
            int codeIdx = 0;
            int inputIdx = 0;
            int count = 0;
            int curIdx = 0;
            while (true) {
                char commandChar = code[codeIdx];
                switch (commandChar) {
                    case '-':
                        memory[pointer]--;
                        break;
                    case '+':
                        memory[pointer]++;
                        break;
                    case '<':
                        pointer--;
                        if (pointer < 0) pointer = Sm - 1;
                        break;
                    case '>':
                        pointer = (pointer + 1) % Sm;
                        break;
                    case '[':
                        if (memory[pointer] == 0) {
                            codeIdx = map.get(codeIdx);
                        }
                        break;
                    case ']':
                        if (memory[pointer] != 0) {
                            codeIdx = map.get(codeIdx);
                        }
                        break;
                    case '.':
                        break;
                    case ',':
                        if (inputIdx == Si) {
                            memory[pointer] = (byte) 255;
                        } else {
                            memory[pointer] = (byte) input[inputIdx++];
                        }
                        break;
                }

                codeIdx++;
                if (codeIdx == Sc) {
                    sb.append("Terminates").append('\n');
                    break;
                }

                count++;
                if (count > 50_000_000) {
                    curIdx = Math.max(curIdx, codeIdx);
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
