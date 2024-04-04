import java.util.*;
import java.io.*;

class Solution {
	static int N;
	static int[][] map, dist;

	// 상,하,좌,우
	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			// Input
			map = new int[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			} // Input End

			sb.append('#').append(tc).append(' ').append(bfs()).append('\n');
		}
		System.out.println(sb);
	}

	private static int bfs() {
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		queue.add(new int[] { 0, 0, 0 });
		dist[0][0] = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nX = cur[0] + dirX[i];
				int nY = cur[1] + dirY[i];

				if (!isIn(nX, nY) || dist[nX][nY] <= cur[2] + map[nX][nY]) {
					continue;
				}
				dist[nX][nY] = map[nX][nY] + cur[2];
				if (nX == N - 1 && nY == N - 1) {
					return dist[nX][nY];
				}
				queue.add(new int[] { nX, nY, dist[nX][nY] });
			}
		}
		return -1;
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}