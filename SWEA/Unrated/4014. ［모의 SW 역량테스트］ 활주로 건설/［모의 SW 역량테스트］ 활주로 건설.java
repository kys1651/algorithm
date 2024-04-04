import java.util.*;
import java.io.*;

class Solution{
	static int N, X, result;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			result = 0;
			// Input
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j * 2) - '0';
				}
			} // Input End

			solve();
			sb.append(String.format("#%d %d\n", tc,result));
		}
		System.out.println(sb);
	}

	private static void solve() {
		for (int i = 0; i < N; i++) {
			if (check(i, true))
				result++;
			if (check(i, false))
				result++;
		}
	}

	private static boolean check(int idx, boolean row) {
		int count = 1, mark = row ? map[idx][0] : map[0][idx];
		for (int i = 1; i < N; i++) {
			int v = row ? map[idx][i] : map[i][idx];
			if (v == mark) {
				count++;
			} else if (v == mark + 1) {
				if (count < X)
					return false;
				count = 1;
				mark = v;
			} else if (v == mark - 1) {
				int j = i + 1, c = 1;
				while (j < N && (row ? map[idx][j] == v : map[j][idx] == v) && c < X) {
					j++;
					c++;
				}
				if (c < X)
					return false;
				mark = v;
				i += X - 1;
				count = 0;
			} else {
				return false;
			}
		}
		return true;
	}
}