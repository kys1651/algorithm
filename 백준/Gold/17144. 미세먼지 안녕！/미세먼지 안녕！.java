import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] air = new int[2][2];
	static int R, C;

	static int[] dirX = { 0, -1, 0, 1 };
	static int[] dirY = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		// Input
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					air[idx][0] = i;
					air[idx++][1] = j;
				}
			}
		} // Input End

		for (int i = 1; i <= T; i++) {
			dust();
			airExcute();
		}
		
		int sum = 0;
		for(int i = 0 ; i < R; i++) {
			for(int j = 0; j < C;j++) {
				sum = sum + map[i][j];
			}
		}
		System.out.println(sum + 2);
	}
	
	// 에어컨 가동
	private static void airExcute() {
		rotate(air[0], true);
		rotate(air[1], false);
	}

	private static void rotate(int[] start, boolean CW) {
		int d = 0;
		int x = start[0] + dirX[d];
		int y = start[1] + dirY[d];
		int prev = map[x][y];
		map[x][y] = 0;
		while (!(x == start[0] && y == start[1])) {
			int nX = x + dirX[d];
			int nY = y + dirY[d];
			if (!isIn(nX, nY)) {
				if (CW) {
					d = (d + 1) % 4;
				} else {
					d = d - 1;
					if (d < 0) {
						d = 3;
					}
				}
				nX = x + dirX[d];
				nY = y + dirY[d];
			}

			int tmp = map[nX][nY];
			map[nX][nY] = prev;
			prev = tmp;
			x = nX;
			y = nY;
		}
		map[x][y] = -1;
	}

	private static void dust() {
		Queue<int[]> queue = new LinkedList<>();
		// 미세먼지 위치 파악
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					queue.add(new int[] { i, j, map[i][j] });
					map[i][j] = 0;
				}
			}
		}

		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
			int count = 0;
			int dustValue = cur[2] / 5;

			for (int i = 0; i < 4; i++) {
				int nX = cur[0] + dirX[i];
				int nY = cur[1] + dirY[i];

				if (!isIn(nX, nY) || map[nX][nY] == -1) {
					continue;
				}
				map[nX][nY] += dustValue;
				count++;
			}
			map[cur[0]][cur[1]] += cur[2] - dustValue * count;
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
