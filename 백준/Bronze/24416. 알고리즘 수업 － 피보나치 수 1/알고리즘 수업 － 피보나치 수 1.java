import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int countDP = 0;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        memo = new int[n+1];
        fib(n);
        fibonacci(n);

        System.out.print(count + " ");
        System.out.println(countDP);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            count++;
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
    private static int fibonacci(int n) {
        memo[1] = memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            countDP++;
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}

