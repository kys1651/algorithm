import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M, K, result;
	static int[][] map;
	static boolean[][] visit;

	static ArrayList<int[]> emptyList = new ArrayList<>();
	static ArrayList<int[]> virus = new ArrayList<>();

	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = input.charAt(0) - '0';
		M = input.charAt(2) - '0';

		// Input
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j * 2) - '0';
				if (map[i][j] == 0) {
					emptyList.add(new int[] { i, j });
				} else if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		} // Input End

		K = emptyList.size();
		per(0, 0);
		System.out.println(result);
	}

	private static void per(int depth, int at) {
		if (depth == 3) {
			virusSpread();
			return;
		}

		for (int i = at; i < K; i++) {
			int[] cur = emptyList.get(i);
			map[cur[0]][cur[1]] = 1;
			per(depth + 1, i + 1);
			map[cur[0]][cur[1]] = 0;
		}
	}

	private static void virusSpread() {
		visit = new boolean[N][M];
		for (int[] v : virus) {
			dfs(v[0], v[1]);
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] != 1) {
					count++;
				}
			}
		}
		if (count > result)
			result = count;
	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nX = x + dirX[i];
			int nY = y + dirY[i];
			if(!isIn(nX,nY) || visit[nX][nY] || map[nX][nY] == 1) {
				continue;
			}
			dfs(nX,nY);
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
