import java.util.*;
import java.io.*;

class Solution{
	static class Node {
		int idx;
		Node next;

		public Node(int idx, Node next) {
			this.idx = idx;
			this.next = next;
		}
	}

	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[] inDegree = new int[N + 1];
			int[] outDegree = new int[N + 1];
			Node[] inGraph = new Node[N + 1];
			Node[] outGraph = new Node[N + 1];

			// Input
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				inGraph[from] = new Node(to, inGraph[from]);
				outGraph[to] = new Node(from, outGraph[to]);
			} // Input End

			int answer = 0;
			for (int i = 1; i <= N; i++) {
				visit = new boolean[N + 1];
				dfs(i, i, inDegree, inGraph);
				visit = new boolean[N + 1];
				dfs(i, i, outDegree, outGraph);
				if(inDegree[i] + outDegree[i] - 1 == N) answer++;
			}
			sb.append(String.format("#%d %d\n", tc, answer));
		}
		System.out.println(sb);
	}

	private static void dfs(int idx, int origin, int[] degree, Node[] graph) {
		visit[idx] = true;
		degree[origin]++;
		for (Node next = graph[idx]; next != null; next = next.next) {
			if (visit[next.idx])
				continue;
			dfs(next.idx, origin, degree, graph);
		}
	}
}