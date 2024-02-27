import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map = new boolean[101][101];

	// 우,상,좌,하
	static int[] dirX = { 0, -1, 0, 1 };
	static int[] dirY = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			// x,y는 반대로 생각해야함
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragonCurve(x, y, d, g);
		}

		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static void dragonCurve(int x, int y, int d, int g) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(d);
		for (int i = 1; i <= g; i++) {
			int size = list.size();
			for (int j = size - 1; j >= 0; j--) {
				list.add((list.get(j) + 1) % 4);
			}
		}

		map[x][y] = true;
		for (int dir : list) {
			x += dirX[dir];
			y += dirY[dir];
			map[x][y] = true;
		}
	}
}
