import java.util.*;
import java.io.*;
class Solution{
    static final long div = 1234567891;
	static long[] fac = new long[1000001];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		fac[0] = fac[1] = 1;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			long numerator = factorial(n);
			long a = factorial(n - r);
			long b = factorial(r);
			long denominator = (a * b) % div;
			
			denominator = pow(denominator, div - 2);
			long result = numerator * denominator % div;
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}

	private static long factorial(int n) {
		if (fac[n] != 0)
			return fac[n];
		for (int i = 1; i <= n; i++) {
			if (fac[i] != 0)
				continue;
			fac[i] = (fac[i - 1] * i) % div;
		}
		return fac[n];
	}

	private static long pow(long base, long exponent) {
		long result = 1;
		while (exponent != 0) {
			if (exponent % 2 != 0) {
				result = result * base % div;
				exponent--;
			}
			exponent = (exponent / 2);
			base = base * base % div;
		}
		return result;
	}
}