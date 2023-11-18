import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int[][] map = new int[16][16];
			boolean[][] visit = new boolean[16][16];
			int startX = 0, startY = 0;
			for (int i = 0; i < map.length; i++) {
				String line = sc.next();
				for (int j = 0; j < line.length(); j++) {
					int value = line.charAt(j) - '0';
					map[i][j] = value;
					if (map[i][j] == 2) {
						startX = i;
						startY = j;
					}
				}
			}
			boolean result = bfs(startX, startY, map, visit);
			System.out.println("#" + tc + " " + (result ? "1" : "0"));
		}
	}

	private static boolean bfs(int startX, int startY, int[][] map, boolean[][] visit) {
		int[] dirX = { -1, 1, 0, 0 };
		int[] dirY = { 0, 0, -1, 1 };
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { startX, startY });
		visit[startX][startY] = true;

		while (!queue.isEmpty()) {
			int[] n = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = n[0] + dirX[i];
				int ny = n[1] + dirY[i];

				if (map[nx][ny] == 1 || visit[nx][ny]) {
					continue;
				}
				if (map[nx][ny] == 3) {
					return true;
				}

				visit[nx][ny] = true;
				queue.offer(new int[] { nx, ny });
			}
		}
		return false;
	}
}