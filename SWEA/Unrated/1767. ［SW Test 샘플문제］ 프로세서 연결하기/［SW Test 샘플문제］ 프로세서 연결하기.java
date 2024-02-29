import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	static int N, K, maxCoreCount, minWireDist;
	static int[][] map;
	static ArrayList<int[]> coreList;

	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			coreList = new ArrayList<>();
			maxCoreCount = 0;
			minWireDist = 144;

			// Input End
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j * 2) - '0';
					if (map[i][j] == 1) {
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
							continue;
						}
						coreList.add(new int[] { i, j });
					}
				}
			} // Input End

			K = coreList.size();
			solve(0, 0, 0);
			sb.append(String.format("#%d %d\n", tc, minWireDist));
		}
		System.out.println(sb);
	}

	private static void solve(int depth, int coreCount, int wireDist) {
		if (depth == K) {
			if (maxCoreCount < coreCount) {
				maxCoreCount = coreCount;
				minWireDist = wireDist;
			} else if (maxCoreCount == coreCount) {
				if (minWireDist > wireDist) {
					minWireDist = wireDist;
				}
			}
			return;
		}

		int[] curCore = coreList.get(depth);
		for (int i = 0; i < 4; i++) {
			if (isLink(curCore[0], curCore[1], i)) {
				int dist = fill(curCore[0], curCore[1], i, 1);
				solve(depth + 1, coreCount + 1, wireDist + dist);
				fill(curCore[0], curCore[1], i, 0);
			}
		}
		solve(depth + 1, coreCount, wireDist);
	}

	private static int fill(int x, int y, int d, int value) {
		int count = 0;
		x += dirX[d];
		y += dirY[d];
		while (true) {
			if (!isIn(x, y)) {
				break;
			}
			map[x][y] = value;
			x += dirX[d];
			y += dirY[d];
			count++;
		}
		return count;
	}

	private static boolean isLink(int x, int y, int d) {
		x += dirX[d];
		y += dirY[d];
		while (true) {
			if (!isIn(x, y)) {
				return true;
			}
			if (map[x][y] == 1) {
				return false;
			}
			x += dirX[d];
			y += dirY[d];
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
