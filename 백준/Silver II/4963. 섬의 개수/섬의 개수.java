import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int H, W;
	static int[][] map;

	// 왼쪽 위, 가운데 위, 오른쪽 위, 왼쪽, 오른쪽,왼쪽아래, 아래,오른쪽 아래
	static int[] dirX = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dirY = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static ArrayList<int[]> list;
	static boolean[][] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (H == 0 && W == 0) {
				break;
			}

			map = new int[H][W];
			visit = new boolean[H][W];
			list = new ArrayList<>();

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						list.add(new int[] { i, j });
					}
				}
			}
			if(list.size() == 0) {
				sb.append("0\n");
				continue;
			}
			int count = 0;
			for (int[] cur : list) {
				if (visit[cur[0]][cur[1]])
					continue;
				bfs(cur[0], cur[1]);
				count++;
			}
			sb.append(count).append('\n');
		}

		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visit[x][y] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nX = cur[0] + dirX[i];
				int nY = cur[1] + dirY[i];

				if (!isIn(nX, nY) || map[nX][nY] == 0 || visit[nX][nY]) {
					continue;
				}

				visit[nX][nY] = true;
				queue.add(new int[] { nX, nY });
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
}
