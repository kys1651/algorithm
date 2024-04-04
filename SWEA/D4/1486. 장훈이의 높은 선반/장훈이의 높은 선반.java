import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution{
	static int N, M, result;
	static int[] height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;

			height = new int[N];
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
				sum = sum + height[i];
			}
			solve(0, 0);
			sb.append('#').append(tc).append(' ').append(result - M).append('\n');
		}
		System.out.println(sb);
	}

	private static void solve(int depth, int sum) {
		if (depth == N) {
			if (sum >= M && sum < result) {
				result = sum;
				return;
			}
			return;
		}
		if ((result != Integer.MAX_VALUE && result <= sum))
			return;
		solve(depth + 1, sum + height[depth]);
		solve(depth + 1, sum);
	}
}