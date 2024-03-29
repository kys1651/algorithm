import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x;
		int y;
		int crush;
		int count;

		public Point(int x, int y, int count, int crush) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.crush = crush;
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M][2];

		st = new StringTokenizer(br.readLine());
		Point start = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0, 1);
		st = new StringTokenizer(br.readLine());
		Point end = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0, 0);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(start, end);

		System.out.println(-1);
	}

	private static void bfs(Point start, Point end) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		// 1: 안부심, 0: 부심
		visit[start.x][start.y][1] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (cur.x == end.x && cur.y == end.y) {
				System.out.println(cur.count);
				System.exit(0);
			}

			for (int i = 0; i < 4; i++) {
				int nX = cur.x + dirX[i];
				int nY = cur.y + dirY[i];

				// 범위내가 아니라면 continue;
				// 현재 상태에서 간 적 있는 곳일 때거나 벽인데 부실 수 없다면
				if (nX < 0 || nX >= N || nY < 0 || nY >= M || visit[nX][nY][cur.crush] || (map[nX][nY] == 1 && cur.crush == 0)) {
					continue;
				}

				// 벽일 때 부시고 간다.
				if (map[nX][nY] == 1) {
					queue.add(new Point(nX, nY, cur.count + 1, 0));
					visit[nX][nY][0] = true;
				}
				// 벽이 아닐 때
				else {
					// 방문한 적 없다면 간다.
					if (!visit[nX][nY][cur.crush]) {
						queue.add(new Point(nX, nY, cur.count + 1, cur.crush));
						visit[nX][nY][cur.crush] = true;
					}
				}
			}
		}
	}
}
