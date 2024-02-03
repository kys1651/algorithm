import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static final char[] top = {'1', '2', '3'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger count = new BigInteger("1");
        sb.append(count.shiftLeft(n).subtract(new BigInteger("1"))).append('\n');

        if (n <= 20) {
            hanoi(n, 1, 3);
        }

        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int to) {
        if (n == 0) return;

        hanoi(n - 1, from, 6 - from - to);
        sb.append(top[from - 1]).append(' ').append(top[to - 1]).append("\n");
        hanoi(n - 1, 6 - from - to, to);
    }
}
