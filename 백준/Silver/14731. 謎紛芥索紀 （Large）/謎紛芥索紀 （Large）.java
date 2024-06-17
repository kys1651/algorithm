import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long c = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            answer = (answer + (c * k % MOD) * pow(k - 1) % MOD) % MOD;
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