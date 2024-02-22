import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visit;
	static int[] peoples;
	static boolean[][] graph;
	static int result = Integer.MAX_VALUE, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// make
		peoples = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			peoples[i] = Integer.parseInt(st.nextToken());
		} // make End

		// 그래프 만들어줌
		graph = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			while (size-- > 0) {
				int next = Integer.parseInt(st.nextToken());
				graph[i][next] = graph[next][i] = true;
			}
		}

		visit = new boolean[N + 1];
		combination(1, 0);

		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	private static void combination(int depth, int at) {
		if (depth == N + 1) {
			if (at == 0 || at == N + 1) {
				return;
			}

			if (!check()) {
				return;
			}

			int a = 0;
			int b = 0;
			for (int i = 1; i <= N; i++) {
				if (visit[i]) {
					a += peoples[i];
				} else {
					b += peoples[i];
				}
			}

			if (result > Math.abs(a - b)) {
				result = Math.abs(a - b);
			}
			return;
		}

		visit[depth] = true;
		combination(depth + 1, at + 1);
		visit[depth] = false;

		combination(depth + 1, at);

	}

	private static boolean check() {
		boolean[] aVisit = new boolean[N + 1];
		boolean[] bVisit = new boolean[N + 1];

		int aStart = 0, bStart = 0;
		for (int i = 1; i <= N; i++) {
			if (visit[i]) {
				aStart = i;
				aVisit[i] = true;
			} else {
				bStart = i;
				bVisit[i] = true;
			}
		}

		dfs(aStart, aVisit);
		dfs(bStart, bVisit);
		for (int i = 1; i <= N; i++) {
			if (aVisit[i] || bVisit[i])
				return false;
		}
		return true;
	}

	private static void dfs(int cur, boolean[] v) {
		v[cur] = false;
		for (int i = 1; i <= N; i++) {
			if (!v[i] || !graph[cur][i]) {
				continue;
			}
			dfs(i, v);
		}
	}
}
