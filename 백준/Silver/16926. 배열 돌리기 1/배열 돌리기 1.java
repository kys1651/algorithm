import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dirX = { 1, 0, -1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = 0;
		int max = 0;
		if (N > M) {
			max = N;
			min = M;
		} else {
			max = M;
			min = N;
		}

		int count = min / 2;
		for (int i = 0; i < count; i++) {
			int k = R % ((max + min-2) * 2);
			for (int j = 0; j < k; j++) {
				rotate(i);
			}
			max -= 2;
			min -= 2;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void rotate(int idx) {
		int x = idx, y = idx;
		int d = 0;
		int prev = map[x][y];
		while (true) {
			int nX = x + dirX[d];
			int nY = y + dirY[d];
			if (nX < idx || nX >= N - idx || nY < idx || nY >= M - idx) {
				d = (d + 1) % 4;
				nX = x + dirX[d];
				nY = y + dirY[d];
			}

			int tmp = map[nX][nY];
			map[nX][nY] = prev;
			prev = tmp;

			x = nX;
			y = nY;
			if (x == idx && y == idx)
				break;
		}

	}
}
