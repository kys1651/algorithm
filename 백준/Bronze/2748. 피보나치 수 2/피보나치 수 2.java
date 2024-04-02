import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new long[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		System.out.println(fibonacci(N));
	}

	private static long fibonacci(int n) {
		if (n <= 1)
			return n;
		if (dp[n] > 0)
			return dp[n];
		return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
	}

}
