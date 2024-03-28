import java.util.*;
import java.io.*;

public class Main {
	static final int INF = 10_000_001;
	static int N;
	static int[][] map;
	static ArrayList<Integer>[][] route;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		init();

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (map[from][to] > cost)
				map[from][to] = cost;
		}

		floydWarshall();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] < INF) {
					sb.append(map[i][j]);
				} else {
					sb.append(0);
				}
				sb.append(' ');
			}
			sb.append('\n');
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j || map[i][j] == INF) {
					sb.append(0);
				} else {
					sb.append(route[i][j].size() + 2).append(' ');
					sb.append(i).append(' ');
					for (int r : route[i][j]) {
						sb.append(r).append(' ');
					}
					sb.append(j).append(' ');
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}

	private static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= N; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						route[i][j].clear();
						for (int r : route[i][k]) {
							route[i][j].add(r);
						}
						route[i][j].add(k);
						for (int r : route[k][j]) {
							route[i][j].add(r);
						}
					}
				}
			}
		}
	}

	private static void init() {
		map = new int[N + 1][N + 1];
		route = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					map[i][j] = INF;
					route[i][j] = new ArrayList<>();
				}
			}
		}

	}
}
