import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Player {
		int x;
		int y;
		int key;
		int count;

		public Player(int x, int y, int key, int count) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.count = count;
		}
	}

	static int N, M, result = Integer.MAX_VALUE;
	static boolean[][][] visit;
	static char[][] map;

	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// Input
		int startX = 0, startY = 0;
		visit = new boolean[(1 << 6)][N][M];
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				char ch = input.charAt(j);
				map[i][j] = ch;
				// 출발지점
				if (ch == '0') {
					map[i][j] = '.';
					startX = i;
					startY = j;
				}
			}
		} // Input End

		bfs(startX, startY);

		System.out.println(-1);
	}

	private static void bfs(int startX, int startY) {
		Queue<Player> queue = new LinkedList<>();
		queue.add(new Player(startX, startY, 0, 0));
		visit[0][startX][startY] = true;
		while (!queue.isEmpty()) {
			Player cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nX = cur.x + dirX[i];
				int nY = cur.y + dirY[i];

				// 배열 범위 밖이거나 || 벽이면 넘어감
				if (!isIn(nX, nY) || map[nX][nY] == '#' || visit[cur.key][nX][nY]) {
					continue;
				}

				char nextPos = map[nX][nY];
				if (nextPos == '.') {
					visit[cur.key][nX][nY] = true;
					queue.add(new Player(nX, nY, cur.key, cur.count + 1));
				} else if (Character.isUpperCase(nextPos)) {
					int keyIdx = nextPos - 'A';
					// 열쇠가 있는 경우
					if ((cur.key & (1 << keyIdx)) != 0) {
						visit[cur.key][nX][nY] = true;
						queue.add(new Player(nX, nY, cur.key, cur.count + 1));
					}
				}
				// 열쇠를 만난 경우
				else if (Character.isLowerCase(nextPos)) {
					int keyIdx = nextPos - 'a';
					int nextKey = cur.key | (1 << keyIdx);
					queue.add(new Player(nX, nY, nextKey, cur.count + 1));
					visit[cur.key][nX][nY] = true;
				} else if (nextPos == '1') {
					System.out.println(cur.count + 1);
					System.exit(0);
				}
			}
		}
	}

	// 배열 범위내인지 확인
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
