import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, limit, emptyCount, result = Integer.MAX_VALUE;
	static int[][] origin;
	static int[] select;
	static Pair[] pos;

	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// Input
		select = new int[M];
		pos = new Pair[N * N];
		origin = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				origin[i][j] = input.charAt(j * 2) - '0';
				if (origin[i][j] == 2) {
					pos[limit++] = new Pair(i, j);
				}
				if (origin[i][j] != 1) {
					emptyCount++;
				}
			}
		} // Input End

		permutation(0, 0);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	private static void permutation(int depth, int at) {
		if (depth == M) {
			simulation();
			return;
		}
		if (at >= limit)
			return;

		select[depth] = at;
		permutation(depth + 1, at + 1);
		select[depth] = 0;
		permutation(depth, at + 1);
	}

	private static void simulation() {
		Queue<Pair> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			Pair p = pos[select[i]];
			queue.add(p);
			visit[p.x][p.y] = true;
		}

		int count = emptyCount - M;
		int time = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			if (count == 0) {
				break;
			}
			if (time >= result) {
				return;
			}
			time++;
			for (int s = 0; s < size; s++) {
				Pair cur = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nX = cur.x + dirX[i];
					int nY = cur.y + dirY[i];
					if (!isIn(nX, nY) || origin[nX][nY] == 1 || visit[nX][nY]) {
						continue;
					}
					count--;
					visit[nX][nY] = true;
					queue.add(new Pair(nX, nY));
				}
			}
		}
		if (count == 0 && time < result) {
			result = time;
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
