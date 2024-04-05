import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, sharkCount, time;

	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };
	static int[][][] sharkDir;

	static Shark[] sharks;
	static int[][] map;
	static Smell[][] smellMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sharkCount = M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sharks = new Shark[M + 1];
		map = new int[N][N];
		smellMap = new Smell[N][N];

		// Map Input
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					sharks[map[i][j]] = new Shark(i, j, map[i][j]);
				}
			}
		} // Map Input End

		// init Direction Input
		String input = br.readLine();
		for (int i = 1; i <= M; i++) {
			int dir = input.charAt((i - 1) * 2) - '0' - 1;
			sharks[i].dir = dir;
		} // init Direction Input End

		// sharkDir Input
		sharkDir = new int[M + 1][4][4];
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					sharkDir[i][j][k] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		} // sharkDir Input End

		spreadSmell();
		for (; time <= 1000;) {
			sharksMove();
			time++;

			removeSmell();
			spreadSmell();

			if (sharkCount == 1) {
				break;
			}
		}

		if (time > 1000) {
			System.out.println(-1);
		} else {
			System.out.println(time);
		}
	}

	// 시간이 된 냄새 제거
	private static void removeSmell() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (smellMap[i][j] != null) {
					smellMap[i][j].count--;
					if (smellMap[i][j].count == 0) {
						smellMap[i][j] = null;
					}
				}
			}
		}
	}

	// 상어 이동
	private static void sharksMove() {
		int[][] nextMap = new int[N][N];
		for (int i = M; i >= 1; i--) {
			// 죽으면 이동 x
			if (sharks[i].death)
				continue;

			// 다음 위치 얻어오기
			int d = sharks[i].getDir();
			int nX = sharks[i].x + dirX[d];
			int nY = sharks[i].y + dirY[d];

			// 다음 위치에 상어 있다면 죽임
			if (nextMap[nX][nY] != 0) {
				int idx = nextMap[nX][nY];
				sharks[idx].death = true;
				sharkCount--;
			}

			// 다음 위치에 아무것도 없다면 위치 세팅 후 이동
			sharks[i].moveSet(nX, nY, d);
			nextMap[nX][nY] = sharks[i].idx;
		}
		map = nextMap;
	}

	// 냄새 뿌리기
	private static void spreadSmell() {
		for (int i = 1; i <= M; i++) {
			Shark s = sharks[i];
			if (s.death)
				continue;
			Smell smell = new Smell(s.idx, K);
			smellMap[s.x][s.y] = smell;
		}
	}

	static class Shark {
		int x;
		int y;
		int idx;
		int dir;
		boolean death;

		public Shark(int x, int y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
		}

		public void moveSet(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		public int getDir() {
			// 냄새 없는 곳 우선 확인
			for (int i = 0; i < 4; i++) {
				int d = sharkDir[idx][dir][i];
				int nX = x + dirX[d];
				int nY = y + dirY[d];
				if (isIn(nX, nY) && smellMap[nX][nY] == null) {
					return d;
				}
			}

			// 냄새 없는 곳이 없다면 현재 상어 인덱스의 냄새인 곳
			for (int i = 0; i < 4; i++) {
				int d = sharkDir[idx][dir][i];
				int nX = x + dirX[d];
				int nY = y + dirY[d];
				if (isIn(nX, nY) && smellMap[nX][nY].sharkIdx == this.idx) {
					return d;
				}
			}

			// 여기까지 오면 유효하지 않은 경우
			return -1;
		}
	}

	static class Smell {
		int sharkIdx;
		int count;

		public Smell(int sharkIdx, int endTime) {
			this.count = endTime;
			this.sharkIdx = sharkIdx;
		}
	}

	static private boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
