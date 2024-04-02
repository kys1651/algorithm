import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	final static long MOD = 1_000_000_000L;
	static HashMap<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		map.put(1L, 1L);
		map.put(2L, 1L);
		map.put(3L, 2L);

		long f1 = fibonacci(a + 1);
		long f2 = fibonacci(b + 2);
		long r = (f2 - f1 + MOD) % MOD;
		System.out.println(r);
	}

	private static long fibonacci(long idx) {
		if (map.containsKey(idx)) {
			return map.get(idx);
		}
		// idx가 짝수 -> F(2n) = (F(n-1) * 2 + F(n)) * F(n)
		if ((idx & 1) == 0) {
			long nIdx = idx / 2;
			long f1 = fibonacci(nIdx - 1);
			long f2 = fibonacci(nIdx);
			long result = ((2 * f1) + f2) * f2 % MOD;
			map.put(idx, result);

			return result;
		}
		// idx가 홀수 -> F(2n+1) = F(n) * F(n) + F(n+1) * F(n+1);
		// F(2n+1) = F(n)^2 +F(n+1)^2;
		else {
			long nIdx = (idx + 1) / 2;
			long f1 = fibonacci(nIdx);
			long f2 = fibonacci(nIdx - 1);
			long result = (f1 * f1 % MOD + f2 * f2 % MOD) % MOD;
			map.put(idx, result);
			return result;
		}
	}
}
