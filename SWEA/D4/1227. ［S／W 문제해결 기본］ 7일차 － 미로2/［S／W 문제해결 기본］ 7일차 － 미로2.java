import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static final int SIZE = 100;
	static char[][] map = new char[SIZE][SIZE];
	static boolean[][] visit;

	static boolean result;
	static int[] dirX = { 0, 1, -1, 0 };
	static int[] dirY = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			visit = new boolean[SIZE][SIZE];
			for (int i = 0; i < SIZE; i++) {
				map[i] = br.readLine().toCharArray();
			}
			result = false;
			dfs(1, 1);
			sb.append(String.format("#%d %d\n", tc, result ? 1 : 0));
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;

		if (map[x][y] == '3') {
			result = true;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nX = x + dirX[i];
			int nY = y + dirY[i];
			if (map[nX][nY] == '1' || visit[nX][nY] || result) {
				continue;
			}
			dfs(nX, nY);
		}
	}
}
