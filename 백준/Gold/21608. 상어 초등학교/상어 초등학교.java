import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, maxLike, maxEmpty, maxX, maxY;
	static int[][] map, likeStudent;

	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// Input
		map = new int[N][N];
		likeStudent = new int[N * N + 1][4];
		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				likeStudent[idx][j] = Integer.parseInt(st.nextToken());
			}
			
			if (i == 0) {
				map[1][1] = idx;
			} else {
				sitStudent(idx);
			}
		} // Input End

//		print();
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int count = 0;
				for (int k = 0; k < 4; k++) {
					int nX = i + dirX[k];
					int nY = j + dirY[k];
					if (isIn(nX, nY)) {
						for (int l : likeStudent[map[i][j]]) {
							if (l == map[nX][nY]) {
								count++;
								break;
							}
						}
					}
				}
				result += getSatisfaction(count);
			}
		}
		System.out.println(result);
	}

	private static void print() {
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " " );
			}
			System.out.println();
		}
	}

	private static void sitStudent(int idx) {
		maxX = maxY = 21;
		maxEmpty = maxLike = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					sitCheck(idx,i,j);
				}
			}
		}
		map[maxX][maxY] = idx;
	}

	private static void sitCheck(int idx,int x, int y) {
		int tmpLike = 0, tmpEmpty = 0;

		for (int i = 0; i < 4; i++) {
			int nX = x + dirX[i];
			int nY = y + dirY[i];
			if (!isIn(nX, nY)) {
				continue;
			}
			
			if (map[nX][nY] == 0) {
				tmpEmpty++;
			} else {
				for (int like : likeStudent[idx]) {
					if (map[nX][nY] == like) {
						tmpLike++;
						break;
					}
				}
			}
		}
		
		if (tmpLike > maxLike) {
			maxLike = tmpLike;
			maxEmpty = tmpEmpty;
			maxX = x;
			maxY = y;
		} else if (tmpLike == maxLike) {
			if (tmpEmpty > maxEmpty) {
				maxEmpty = tmpEmpty;
				maxX = x;
				maxY = y;
			} else if (tmpEmpty == maxEmpty) {
				if (x < maxX) {
					maxX = x;
					maxY = y;
				} else if (x == maxX) {
					maxY = Math.min(y, maxY);
				}
			}
		}
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
