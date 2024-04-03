import java.util.*;
import java.io.*;


class Solution{
	static int N, min, max;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			num = new int[N];
			// Input
			StringTokenizer st = new StringTokenizer(br.readLine());
			int plus = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			int mul = Integer.parseInt(st.nextToken());
			int div = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			} // Input End

			solve(1, num[0], plus, minus, mul, div);
			sb.append(String.format("#%d %d\n", tc,max- min));
		}
		System.out.println(sb);
	}

	private static void solve(int depth, int value, int plus, int minus, int mul, int div) {
		if (depth == N) {
			if (max < value)
				max = value;
			if (min > value)
				min = value;
			return;
		}

		if (plus > 0) solve(depth + 1, value + num[depth], plus - 1, minus, mul, div);
		if (minus > 0) solve(depth + 1, value - num[depth], plus, minus - 1, mul, div);
		if (mul > 0) solve(depth + 1, value * num[depth], plus, minus, mul - 1, div);
		if (div > 0) solve(depth + 1, value / num[depth], plus, minus, mul, div - 1);
	}
}