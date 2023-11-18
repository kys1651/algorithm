import java.util.*;

class Solution {
	static int[][] map;
	static HashSet<String> answer;
	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };
	static char[] value;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			map = new int[4][4];
			answer = new HashSet<>();
			value = new char[7];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, 0);
				}
			}
			System.out.println("#" + tc + " " + answer.size());
		}
	}

	private static void dfs(int x, int y, int depth) {
		if (depth == 7) {
			answer.add(new String(value));
			return;
		}
		value[depth] = (char) (map[x][y] + '0');
		for (int i = 0; i < 4; i++) {
			int nx = x + dirX[i];
			int ny = y + dirY[i];
			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length) {
				continue;
			}
			char tmp = value[depth];
			value[depth] = (char) ('0' + map[nx][ny]);
			dfs(nx, ny, depth + 1);
			value[depth] = tmp;
		}
	}
}