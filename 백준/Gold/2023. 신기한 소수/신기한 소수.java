import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] firstUnitPrime = {2, 3, 5, 7};
    static int[] secondUnitPrime = {1, 3, 7, 9};
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new int[N];

        for (int i = 0; i < firstUnitPrime.length; i++) {
            combination(1, firstUnitPrime[i]);
        }

        System.out.println(sb);
    }

    private static void combination(int depth, int value) {
        if (depth == N) {
            sb.append(value).append("\n");
            return;
        }

        for (int i = 0; i < secondUnitPrime.length; i++) {
            int nextValue = value * 10 + secondUnitPrime[i];
            if (isValid(nextValue)) {
                combination(depth + 1, nextValue);
            }
        }
    }

    private static boolean isValid(int value) {
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
