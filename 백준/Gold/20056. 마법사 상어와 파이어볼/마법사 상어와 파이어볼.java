import java.util.*;
import java.io.*;

public class Main {
	static class FireBall {
		int x; // x
		int y; // y
		int m; // 질량
		int s; // 속력
		int d; // 방향
		// -1: 전부 다름
		// 0 : 처음 들어오는 경우
		// 1 : 기존 파이어볼 홀수
		// 2 : 기존 파이어볼 짝수
		int count;

		public FireBall(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		public void init() {
			this.m = 0;
			this.s = 0;
			this.d = -1;
			this.count = 0;
		}
	}

	static int[] dirX = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dirY = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static Queue<FireBall> queue = new LinkedList<>();
	static FireBall[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		init();

		// Input
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			queue.add(new FireBall(x, y, m, s, d));
		} // Input End

		for (int i = 0; i < K; i++) {
			moveFireBall();
			print();
			nextFireBall();
		}
		int answer = getResult();
		System.out.println(answer);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].m == 0)
					continue;
			}
		}
	}

	private static int getResult() {
		int answer = 0;
		while (!queue.isEmpty()) {
			answer += queue.poll().m;
		}
		return answer;
	}

	private static void nextFireBall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].count == 1) {
					queue.add(new FireBall(i, j, map[i][j].m, map[i][j].s, map[i][j].d));
					map[i][j].init();
				}
				if (map[i][j].m == 0)
					continue;
				else if (map[i][j].m / 5 == 0) {
					map[i][j].init();
					continue;
				}
				int nextM = map[i][j].m / 5;
				int nextS = map[i][j].s / map[i][j].count;
				int nextD = map[i][j].d == -1 ? 1 : 0;
				for (; nextD < 8; nextD += 2) {
					queue.add(new FireBall(i, j, nextM, nextS, nextD));
				}
				map[i][j].init();
			}
		}
	}

	private static void moveFireBall() {
		while (!queue.isEmpty()) {
			FireBall f = queue.poll();
			int x = f.x;
			int y = f.y;
			for (int i = 0; i < f.s % N; i++) {
				int nX = x + dirX[f.d];
				int nY = y + dirY[f.d];
				if (!isIn(nX, nY)) {
					if (nX >= N || nY >= N) {
						nX %= N;
						nY %= N;
					}
					if (nX < 0)
						nX = N - 1;
					if (nY < 0)
						nY = N - 1;

				}
				x = nX;
				y = nY;
			}
			f.x = x;
			f.y = y;

			if (map[x][y].count == 0) {
				map[x][y].d = f.d;
			} else if (map[x][y].d != -1 && map[x][y].d % 2 != f.d % 2) {
				map[x][y].d = -1;
			}
			map[x][y].m += f.m;
			map[x][y].s += f.s;
			map[x][y].count++;
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	private static void init() {
		map = new FireBall[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new FireBall(i, j, 0, 0, -1);
			}
		}

	}
}
