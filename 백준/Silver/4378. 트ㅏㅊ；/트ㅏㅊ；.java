import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Character> map = new HashMap<>();
        map.put('W', 'Q'); map.put('S', 'A'); map.put('X', 'Z');
        map.put('E', 'W'); map.put('F', 'D'); map.put('C', 'X');
        map.put('R', 'E'); map.put('G', 'F'); map.put('V', 'C');
        map.put('T', 'R'); map.put('H', 'G'); map.put('B', 'V');
        map.put('Y', 'T'); map.put('J', 'H'); map.put('N', 'B');
        map.put('U', 'Y'); map.put('K', 'J'); map.put('M', 'N');
        map.put('I', 'U'); map.put('L', 'K'); map.put(',', 'M');
        map.put('O', 'I'); map.put(';', 'L'); map.put('.', ',');
        map.put('P', 'O'); map.put('\'', ';');map.put('/', '.');
        map.put('[','P');  map.put(']','[');  map.put('\\', ']');
        map.put('-', '0'); map.put('D', 'S'); map.put('`', ';');
        map.put('=', '-'); map.put('\"',';'); map.put(':', 'L');

        String[] inputs = new String[1000000];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = br.readLine();
            if (inputs[i] == null) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < inputs.length; j++) {
            if(inputs[j] == null) break;
            char[] input = inputs[j].toCharArray();
            for (int i = 0; i < input.length; i++) {
                if (input[i] == ' ') {
                    continue;
                } else if (input[i] >= '0' && input[i] <= '9') {
                    if (input[i] == '1') {
                        input[i] = '`';
                    } else if(input[i] == '0'){
                        input[i] = '9';
                    }else{
                        input[i] = (char) (input[i] - 1);
                    }
                } else {
                    input[i] = map.get(input[i]);
                }
            }
            sb.append(input).append('\n');
        }
        System.out.println(sb);
    }
}
