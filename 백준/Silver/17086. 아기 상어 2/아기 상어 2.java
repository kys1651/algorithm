import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[][] visit;
	static Queue<int[]> queue = new LinkedList<>();

	static int[] dirX = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dirY = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				String tmp  = st.nextToken();
				if (tmp.equals("1")) {
					visit[i][j] = true;
					queue.add(new int[] { i, j });
				}
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		int count = -1;

		while (!queue.isEmpty()) {
			count++;
			int size = queue.size();
			
			for (int s = 0; s < size; s++) {
				int[] cur = queue.poll();

				for (int i = 0; i < 8; i++) {
					int nX = cur[0] + dirX[i];
					int nY = cur[1] + dirY[i];

					if (!isIn(nX, nY) || visit[nX][nY]) {
						continue;
					}
					visit[nX][nY] = true;
					queue.add(new int[] { nX, nY });
				}
			}
			
		}

		return count;
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
