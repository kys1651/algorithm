import java.util.*;
import java.io.*;

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

	static boolean[][][] visit;
	static char[][] map;
	static int N, M, sX, sY;

	static int[] dirX = { 1, 0, -1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N][M][(1 << 7)];

		// Input
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '0') {
					map[i][j] = '.';
					sX = i;
					sY = j;
				}
			}
		} // Input End

		int result = bfs();
		System.out.println(result);
	}

	private static int bfs() {
		Queue<Player> queue = new LinkedList<>();
		queue.offer(new Player(sX, sY, 0, 0));
		visit[sX][sY][0] = true;

		while (!queue.isEmpty()) {
			Player cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nX = cur.x + dirX[i];
				int nY = cur.y + dirY[i];

				if (!isIn(nX, nY) || visit[nX][nY][cur.key] || map[nX][nY] == '#') {
					continue;
				}
				visit[nX][nY][cur.key] = true;

				char val = map[nX][nY];
				// 도착시 카운트 값 리턴
				if (val == '1') {
					return cur.count + 1;
				}

				if (val == '.') {
					queue.offer(new Player(nX, nY, cur.key, cur.count + 1));
				}
				// 문인 경우
				else if (Character.isUpperCase(val)) {
					// 열쇠가 있다면 진행
					if ((cur.key | getKey(val)) == cur.key) {
						queue.offer(new Player(nX, nY, cur.key, cur.count + 1));
					}
				}
				// 열쇠인 경우
				else if (Character.isLowerCase(val)) {
					int nextKey = cur.key;
					// 열쇠를 보유하지 않았었다면 가져간다.
					if ((nextKey | getKey(val)) != cur.key) {
						nextKey = nextKey | getKey(val);
						visit[nX][nY][nextKey] = true;
					}
					queue.offer(new Player(nX, nY, nextKey, cur.count + 1));
				}
			}
		}
		return -1;
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	private static int getKey(char key) {
		switch (key) {
		case 'a':
		case 'A':
			return 1 << 1;
		case 'b':
		case 'B':
			return 1 << 2;
		case 'c':
		case 'C':
			return 1 << 3;
		case 'd':
		case 'D':
			return 1 << 4;
		case 'e':
		case 'E':
			return 1 << 5;
		case 'f':
		case 'F':
			return 1 << 6;
		default:
			return 0;
		}
	}
}
