import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, result, map[][];
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			map = new int[N][N];
			visit = new boolean[N];
			// input
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			combination(0, 0);
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}

	private static void combination(int depth, int at) {
		if (depth == N / 2) {
			int tmp = calc();
			if (tmp < result)
				result = tmp;
			return;
		}

		for (int i = at; i < N; i++) {
			visit[i] = true;
			combination(depth + 1, i + 1);
			visit[i] = false;
		}
	}

	private static int calc() {
		int a = 0, b = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visit[i] && visit[j]) {
					a += map[i][j] + map[j][i];
				} else if (!visit[i] && !visit[j]) {
					b += map[i][j] + map[j][i];
				}
			}
		}
		return Math.abs(a - b);
	}

}
