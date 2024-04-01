import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static final long mod = 1_000_000_007L;
	static long[] fac;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		fac = new long[n + 1];
		fac[0] = fac[1] = 1;
		long numerator = factorial(n);
		long denominator = fac[n- r] * fac[r] % mod;

		denominator = pow(denominator, mod - 2);
		long result = numerator * denominator % mod;
		System.out.println(result);
	}

	private static long factorial(int n) {
		if (n == 0)
			return 1;
		if (fac[n] != 0)
			return fac[n];
		for (int i = 1; i <= n; i++) {
			if (fac[i] != 0)
				continue;
			fac[i] = fac[i - 1] * i % mod;
		}
		return fac[n];
	}

	private static long pow(long base, long exponent) {
		long result = 1;
		while (exponent != 0) {
			if (exponent % 2 != 0) {
				result = result * base % mod;
				exponent--;
			}
			exponent = exponent >> 1;
			base = base * base % mod;
		}
		return result;
	}
}
