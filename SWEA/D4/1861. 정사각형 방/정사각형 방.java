import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] map, visit;
	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());

			map = new int[n][n];
			visit = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j] == 0) {
						bfs(i, j);
					}
				}
			}

			int startNum = 0, maxCount = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j] > maxCount) {
						maxCount = visit[i][j];
						startNum = map[i][j];
					}else if(visit[i][j] == maxCount) {
						startNum = Math.min(map[i][j], startNum);
					}
				}
			}
			sb.append(String.format("#%d %d %d\n", tc, startNum, maxCount));
		}
		System.out.println(sb);

	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visit[x][y] = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nX = cur[0] + dirX[i];
				int nY = cur[1] + dirY[i];

				if (!isCheck(nX, nY)) {
					continue;
				}
				if (map[nX][nY] == map[cur[0]][cur[1]] - 1) {
					visit[nX][nY] = visit[cur[0]][cur[1]] + 1;
					queue.offer(new int[] { nX, nY });
				}
			}
		}
	}

	private static boolean isCheck(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}
