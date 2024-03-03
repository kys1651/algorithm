import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    static int N, M, len;
    static LinkedList<Character> input;
    static HashSet<String> check;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            len = N / 4;
            check = new HashSet<>();
            list = new ArrayList<>();
            input = new LinkedList<>();

            // Input
            for (char ch : br.readLine().toCharArray()) {
                input.add(ch);
            }
            // Input End

            for(int i = 0; i < len; i++) {
                parse();
            }
            Collections.sort(list, Collections.reverseOrder());
            sb.append(String.format("#%d %s\n", tc, new BigInteger(list.get(M - 1), 16).toString()));
        }
        System.out.println(sb);
    }

    private static void parse() {
        for (int i = 0; i < 4; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i * len; j < i * len + len; j++) {
                sb.append(input.get(j));
            }
            String value = sb.toString();
            if (check.contains(value)) {
                continue;
            }
            check.add(value);
            list.add(value);
        }

        input.add(0, input.remove(input.size() - 1));
    }
}
