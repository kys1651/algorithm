import java.util.*;

class Solution {
	static char[][] map;
	static int n;
	static int result;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			result = 0;
			map = new char[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = sc.next().toCharArray();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '.') {
						check(i, j, false);
					}
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == '.') result++;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void check(int x, int y, boolean call) {
		int[] dirX = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dirY = { 0, 0, -1, 1, -1, 1, -1, 1 };
		int count = 0;
		for (int i = 0; i < dirX.length; i++) {
			int nx = x + dirX[i];
			int ny = y + dirY[i];
			// 범위 밖이면 신경 쓸 일 없
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				continue;
			}
			if (map[nx][ny] == '*') {
				count++;
			}
		}
		if (count == 0) {
			map[x][y] = 0;
			for (int i = 0; i < dirX.length; i++) {
				int nx = x + dirX[i];
				int ny = y + dirY[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				if(map[nx][ny] == '.') check(nx,ny,true);
			}
			if(!call) result++;
		}else if(call) {
			map[x][y] = (char)(count + '0');
		}
	}

}