import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] num, operator;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        combination(1, num[0], 0, 0, 0, 0);

        System.out.println(max + "\n" + min);
    }

    private static void combination(int depth, int value, int plus, int sub, int mul, int div) {
        if (depth == N) {
            if(min > value) min = value;
            if(max < value) max = value;
            return;
        }

        if(plus < operator[0]) combination(depth + 1, value + num[depth], plus + 1, sub, mul, div);
        if(sub  < operator[1]) combination(depth + 1, value - num[depth], plus, sub + 1, mul, div);
        if(mul < operator[2]) combination(depth + 1, value * num[depth], plus, sub, mul + 1, div);
        if(div < operator[3]) combination(depth + 1, value / num[depth], plus, sub, mul, div + 1);
    }
}
