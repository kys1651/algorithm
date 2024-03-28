import java.io.*;
import java.util.*;

public class Main{
	static class Point {
		int x;
		int y;

		public Point(int i, int j) {
			this.x = i;
			this.y = j;
		}
	}

	static int R, C;
	static boolean exit;
	static char[][] map;
	static boolean[][] visit;
	static Queue<Point> water = new LinkedList<>();
	static Queue<Point> player = new LinkedList<>();

	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '*') {
					water.add(new Point(i, j));
				} else if (map[i][j] == 'X') {
					map[i][j] = '*';
				} else if (map[i][j] == 'S') {
					player.add(new Point(i, j));
					map[i][j] = '.';
				}
			}
		}

		int time = 0;
		while (!(water.isEmpty() && player.isEmpty())) {
			time++;
			waterSpread();
			bfs();
			if (exit)
				break;
		}

		System.out.println(exit ? time : "KAKTUS");
	}

	private static void waterSpread() {
		int size = water.size();
		for (int s = 0; s < size; s++) {
			Point cur = water.poll();

			for (int i = 0; i < 4; i++) {
				int nX = cur.x + dirX[i];
				int nY = cur.y + dirY[i];

				if (!isIn(nX, nY) || map[nX][nY] == '*' || map[nX][nY] == 'D') {
					continue;
				}
				map[nX][nY] = '*';
				water.add(new Point(nX, nY));
			}
		}
	}

	private static void bfs() {
		int size = player.size();
		for (int s = 0; s < size; s++) {
			Point cur = player.poll();
			for (int i = 0; i < 4; i++) {
				int nX = cur.x + dirX[i];
				int nY = cur.y + dirY[i];

				if (!isIn(nX, nY) || visit[nX][nY] || map[nX][nY] == '*') {
					continue;
				}
				if (map[nX][nY] == 'D') {
					exit = true;
					return;
				}
				visit[nX][nY] = true;
				player.add(new Point(nX, nY));
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}

}
