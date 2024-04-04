import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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

			bfs();
			sb.append('#').append(tc).append(' ').append(dist[N - 1][N - 1]).append('\n');
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		dist[0][0] = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int value = dist[cur[0]][cur[1]];
			for (int i = 0; i < 4; i++) {
				int nX = cur[0] + dirX[i];
				int nY = cur[1] + dirY[i];

				if (!isIn(nX, nY) || dist[nX][nY] <= value + map[nX][nY]) {
					continue;
				}
				if(nX == -1 && nY == -1) {
					return;
				}
				dist[nX][nY] = map[nX][nY] + value;
				queue.add(new int[] { nX, nY });
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}