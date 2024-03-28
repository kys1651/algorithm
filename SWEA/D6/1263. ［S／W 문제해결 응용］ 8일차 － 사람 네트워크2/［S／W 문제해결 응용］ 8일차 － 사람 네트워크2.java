import java.util.*;
import java.io.*;

public class Solution {
	static final int INF = 100001;
	static int[][] map;
	static int N;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			init();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						map[i][j] = 1;
					}
				}
			}
			solve();
			int result = getResult();
			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}

	private static int getResult() {
		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int tmp = 0;
			for (int j = 1; j <= N; j++) {
				tmp += map[i][j];
				if (result < tmp)
					break;
			}
			if (result > tmp)
				result = tmp;
		}
		return result;
	}

	private static void solve() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k || map[i][k] == INF)
					continue;
				for (int j = 1; j <= N; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
	}

	private static void init() {
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = INF;
			}
			map[i][i] = 0;
		}
	}
}
