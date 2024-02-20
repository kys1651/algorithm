import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int W, H;
	static int[][] map;
	static boolean[][] visit;

	static int dirX[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dirY[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (H == 0 && W == 0) {
				break;
			}

			map = new int[H][W];
			visit = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1 && !visit[i][j]) {
						count++;
						dfs(i, j);
					}
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int nX = x + dirX[i];
			int nY = y + dirY[i];
			if (!isIn(nX, nY) || map[nX][nY] != 1 || visit[nX][nY]) {
				continue;
			}
			dfs(nX, nY);
		}

	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
}
