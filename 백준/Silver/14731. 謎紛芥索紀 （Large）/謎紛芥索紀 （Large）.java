import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long c = Integer.parseInt(st.nextToken());
            long k = Integer.parseInt(st.nextToken());

            long a = c * k % MOD;
            long b = pow(k - 1);
            long add = a * b % MOD;
            answer = (answer + add) % MOD;
        }
        System.out.println(answer);
    }

    private static long pow(long expo) {
        if (expo == -1) return 0;
        long answer = 1, base = 2;
        while (expo != 0) {
            if (expo % 2 != 0) {
                answer = answer * base % MOD;
                expo--;
            }
            expo >>= 1;
            base = base * base % MOD;
        }
        return answer % MOD;
    }
}