import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, result, sum, map[][], row[], col[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			map = new int[N][N];
			row = new int[N];
			col = new int[N];
			sum = 0;

			// input
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					sum += map[i][j];
				}
			}
			// 누적합
			for (int i = 0; i < N; i++) {
				int r = 0;
				int c = 0;
				for (int j = 0; j < N; j++) {
					r += map[i][j];
					c += map[j][i];
				}
				row[i] = r;
				col[i] = c;
			}
			combination(0, sum);
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}

	private static void combination(int depth, int sum) {
		if (depth == N) {
			if(result > Math.abs(sum)) result = Math.abs(sum);
			return;
		}
		
		combination(depth+1, sum - row[depth] - col[depth]);
		combination(depth+1, sum);
	}
}
