import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, result;
	static Node[] nodes;
	static Node Home, Company;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			result = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			nodes = new Node[N];
			visit = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			Company = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < N; i++) {
				nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			for (int i = 0; i < N; i++) {
				visit[i] = true;
				dfs(1, getDistance(nodes[i], Company), nodes[i]);
				visit[i] = false;
			}

			sb.append(String.format("#%d %d\n", tc, result));
		}
		
		System.out.println(sb);
	}

	private static void dfs(int depth, int distanceSum, Node cur) {
		if (depth == N) {
			int goHome = getDistance(cur, Home);
			if (goHome + distanceSum < result) {
				result = goHome + distanceSum;
			}
			return;
		}

		if (distanceSum > result)
			return;

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			dfs(depth + 1, distanceSum + getDistance(cur, nodes[i]), nodes[i]);
			visit[i] = false;
		}

	}

	private static int getDistance(Node a, Node b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}
