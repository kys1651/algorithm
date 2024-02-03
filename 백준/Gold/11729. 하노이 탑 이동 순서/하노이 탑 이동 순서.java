import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final char[] top = {'1','2','3'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = (1 << N) - 1;
        sb.append(count).append('\n');
        hanoi(N, 1, 3, 2);

        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int to, int mid) {
        if(n == 0) return;

        hanoi(n - 1, from, mid, to);
        sb.append(top[from - 1]).append(' ').append(top[to - 1]).append('\n');
        hanoi(n - 1, mid, to, from);
    }
}