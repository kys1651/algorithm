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

        combination(1, num[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void combination(int depth, int value) {
        if (depth == N) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) continue;

            int nextValue = value;
            int curValue = num[depth];
            if (i == 0) {
                nextValue += curValue;
            } else if (i == 1) {
                nextValue -= curValue;
            } else if (i == 2) {
                nextValue *= curValue;
            } else {
                nextValue /= curValue;
            }
            operator[i]--;
            combination(depth + 1, nextValue);
            operator[i]++;
        }
    }
}
