import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<int[]> list = new ArrayList<>();

	static char[][] map;
	static int[][] startPoint;
	static int[][][] visit;
	static int[] start, end;

	static int N, M, result = Integer.MAX_VALUE;

	static boolean[] check;

	// 방향 배열
	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		// Input
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'X') {
					list.add(new int[] { i, j });
				} else if (map[i][j] == 'S') {
					start = new int[] { i, j };
				} else if (map[i][j] == 'E') {
					end = new int[] { i, j };
				}
			}
		}

		visit = new int[list.size()][N][M];
		startPoint = new int[N][M];
		bfs(startPoint, start[0], start[1]);

		for (int i = 0; i < list.size(); i++) {
			bfs(visit[i], list.get(i)[0], list.get(i)[1]);
		}

		if (list.size() == 0) {
			System.out.println(startPoint[end[0]][end[1]] - 1);
			return;
		}

		check = new boolean[list.size()];
		for (int i = 0; i < list.size(); i++) {
			int[] f = list.get(i);
			combination(0, startPoint[f[0]][f[1]] - 1, i);
		}

		System.out.println(result);
	}

	private static void combination(int depth, int count, int at) {
		if (result <= count) {
			return;
		}

		if (depth == list.size()) {
			count += visit[at][end[0]][end[1]] - 1;
			if (result > count) {
				result = count;
			}
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (check[i])
				continue;

			check[i] = true;
			// at -> i로 가는 거
			int[] next = list.get(i);
			int tmp = visit[at][next[0]][next[1]] - 1;
			combination(depth + 1, count + tmp, i);
			check[i] = false;
		}
	}

	private static void bfs(int[][] arr, int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		arr[x][y] = 1;

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nX = pos[0] + dirX[i];
				int nY = pos[1] + dirY[i];
				// 배열 범위 밖이거나 || 벽이거나 || 방문한 적 있다면 넘어감
				if (!isIn(nX, nY) || map[nX][nY] == '#' || arr[nX][nY] != 0) {
					continue;
				}
				arr[nX][nY] = arr[pos[0]][pos[1]] + 1;
				queue.add(new int[] { nX, nY });
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
