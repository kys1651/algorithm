import java.util.*;
import java.io.*;

public class Main {
	static final int INF = 10_000_001;
	static int N;
	static int[][] map;
	static int[][] next;

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
			if (map[from][to] > cost) {
				map[from][to] = cost;
				next[from][to] = to;
			}
		}

		floydWarshall();

		// Output
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
				ArrayList<Integer> route = getRoute(i,j);
				sb.append(route.size()).append(' ');
				for(int r : route) {
					sb.append(r).append(' ');
				}
				sb.append('\n');
			}
		}// Output End
		
		System.out.println(sb);
	}

	private static ArrayList<Integer> getRoute(int i, int j) {
		ArrayList<Integer> list = new ArrayList<>();
		if(next[i][j] < 0) return list;
		
		list.add(i);
		while(i != j) {
			i = next[i][j];
			list.add(i);
		}
		return list;
	}

	private static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k) continue;
				for (int j = 1; j <= N; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}
	}

	private static void init() {
		map = new int[N + 1][N + 1];
		next = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = INF;
				next[i][j] = -1;
			}
			map[i][i] = 0;
		}

	}
}
