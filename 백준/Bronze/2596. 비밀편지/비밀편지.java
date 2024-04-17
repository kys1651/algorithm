import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<String, Character> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map.put("000000", 'A');
        map.put("001111", 'B');
        map.put("010011", 'C');
        map.put("011100", 'D');
        map.put("100110", 'E');
        map.put("101001", 'F');
        map.put("110101", 'G');
        map.put("111010", 'H');

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int startIdx = i * 6;
            int endIdx = (i + 1) * 6;
            String sub = input.substring(startIdx, endIdx);
            char ch = isValid(sub);
            if (ch != '0') {
                sb.append(ch);
            } else {
                sb = new StringBuilder("" + (i + 1));
                break;
            }
        }

        System.out.println(sb);
    }

    private static char isValid(String a) {
        for (String str : map.keySet()) {
            int count = 0;
            for (int i = 0; i < 6; i++) {
                if(str.charAt(i) != a.charAt(i)) count++;
                if(count >= 2) break;
            }
            if(count <= 1) return map.get(str);
        }
        return '0';
    }
}
