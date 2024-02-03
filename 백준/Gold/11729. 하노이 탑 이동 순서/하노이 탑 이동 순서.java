import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final String[][] answer = {
            {"", "1 2\n", "1 3\n"},
            {"2 1\n", "", "2 3\n"},
            {"3 1\n", "3 2\n"}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb.append((1 << N) - 1).append('\n');
        
        hanoi(N, 1, 3, 2);

        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int to, int mid) {
        if (n == 0) return;

        hanoi(n - 1, from, mid, to);
        sb.append(answer[from - 1][to - 1]);
        hanoi(n - 1, mid, to, from);
    }
}
