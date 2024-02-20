import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count, prev;
	static int[][] map;
	static boolean[][] visit;

	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// Input
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					count++;
				}
			}
		}

		int time = 0;
		while (count != 0) {
			visit = new boolean[N][M];
			prev = 0;
			time++;
			dfs(0, 0);
			count -= prev;
		}
		System.out.println(time);
		System.out.println(prev);
	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;

		if (map[x][y] == 1) {
			map[x][y] = 0;
			prev++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nX = x + dirX[i];
			int nY = y + dirY[i];
			if (!isIn(nX, nY) || visit[nX][nY]) {
				continue;
			}
			dfs(nX, nY);
		}

	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
