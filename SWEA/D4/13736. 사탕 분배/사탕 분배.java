import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			long K = Long.parseLong(st.nextToken());
			long mod = A + B;
			B = (A * pow(K, mod)) % mod;
			sb.append('#').append(tc).append(' ').append(Math.min(B, mod - B)).append('\n');
		}
		System.out.println(sb);
	}

	private static long pow(long expo, long mod) {
		long ret = 1, base = 2;
		while (expo > 0) {
			if (expo % 2 != 0) {
				expo--;
				ret = (ret * base) % mod;
			}
			expo /= 2;
			base = (base * base) % mod;
		}
		return ret;
	}
}
