import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;

	static int[][] likeStudent;
	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int result = 0;
		map = new int[N][N];
		likeStudent = new int[N * N + 1][4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = Integer.parseInt(st.nextToken());
		map[1][1] = idx;
		likeStudent[idx][0] = Integer.parseInt(st.nextToken());
		likeStudent[idx][1] = Integer.parseInt(st.nextToken());
		likeStudent[idx][2] = Integer.parseInt(st.nextToken());
		likeStudent[idx][3] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			idx = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				likeStudent[idx][j] = Integer.parseInt(st.nextToken());
			}
			sitStudent(idx);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int count = 0;
				for (int k = 0; k < 4; k++) {
					int nX = i + dirX[k];
					int nY = j + dirY[k];
					if (isIn(nX, nY)) {
						int cur = map[i][j];
						if (map[nX][nY] == likeStudent[cur][0] || map[nX][nY] == likeStudent[cur][1]
								|| map[nX][nY] == likeStudent[cur][2] || map[nX][nY] == likeStudent[cur][3]) {
							count++;
						}
					}
				}
				result += getSatisfaction(count);
			}
		}
		System.out.println(result);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void sitStudent(int idx) {
		int maxLike = 0, maxEmpty = 0;
		int x = 21, y = 21;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmpLike = 0, tmpEmpty = 0;

				if (map[i][j] == 0) {
					for (int k = 0; k < 4; k++) {
						int nX = i + dirX[k];
						int nY = j + dirY[k];
						if (!isIn(nX, nY)) {
							continue;
						}
						if (map[nX][nY] == 0) {
							tmpEmpty++;
						} else if (map[nX][nY] == likeStudent[idx][0] || map[nX][nY] == likeStudent[idx][1]
								|| map[nX][nY] == likeStudent[idx][2] || map[nX][nY] == likeStudent[idx][3]) {
							tmpLike++;
						}
					}
					if (maxLike < tmpLike) {
						maxLike = tmpLike;
						maxEmpty = tmpEmpty;
						x = i;
						y = j;
					} else if (maxLike == tmpLike) {
						if (maxEmpty < tmpEmpty) {
							maxEmpty = tmpEmpty;
							x = i;
							y = j;
						} else if (maxEmpty == tmpEmpty) {
							if (x > i) {
								x = i;
								y = j;
							} else if (x == i) {
								if (y > j) {
									y = j;
								}
							}
						}
					}
				}
			}
		}

		map[x][y] = idx;
	}

	private static int getSatisfaction(int x) {
		switch (x) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 10;
		case 3:
			return 100;
		default:
			return 1000;
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
