import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, K, limit, result;
    static String[] word;
    static HashSet<Character> set = new HashSet<>();
    static char[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        word = new String[N];


        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            word[i] = input;
            for (int j = 0; j < input.length(); j++) {
                set.add(input.charAt(j));
            }
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }

        alpha = new char[set.size() - 5];

        for (char ch : set) {
            if (ch == 'a' || ch == 't' || ch == 'n' || ch == 'i' || ch == 'c') {
                continue;
            }
            alpha[limit++] = ch;
        }

        set.clear();
        set.add('a');
        set.add('n');
        set.add('t');
        set.add('i');
        set.add('c');

        combination(0, 0);

        System.out.println(result);
    }

    private static void combination(int depth, int at) {
        if (depth > K - 5) return;
        int count = getWordCount();
        if (result < count) result = count;

        if (result == N) {
            System.out.println(N);
            System.exit(0);
        }

        for (int i = at; i < limit; i++) {
            set.add(alpha[i]);
            combination(depth + 1, i + 1);
            set.remove(alpha[i]);
        }
    }

    private static int getWordCount() {
        int count = N;
        for (int i = 0; i < N; i++) {
            for (int j = 4; j < word[i].length() - 4; j++) {
                if (!set.contains(word[i].charAt(j))) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
