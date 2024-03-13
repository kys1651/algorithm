import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int idx;
		int degree;
		Node next;

		public Node(int idx, Node next) {
			this.idx = idx;
			this.next = next;
		}
	}

	static int N, K,W;
	static int[] D;
	static int[] indegree;
	static Node[] graph;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			D = new int[N + 1];
			dp = new long[N + 1];
			graph = new Node[N + 1];
			indegree = new int[N + 1];

			Arrays.fill(dp, -1);

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				indegree[end]++;
				graph[start] = new Node(end, graph[start]);
			}
			W = Integer.parseInt(br.readLine());
			
			solve();
			
			System.out.println(dp[W]);
		}
	}

	private static void solve() {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
				dp[i] = D[i];
			}
		}

		while (!queue.isEmpty()) {
			int idx = queue.poll();
			long value = dp[idx];
			for (Node tmp = graph[idx]; tmp != null; tmp = tmp.next) {
				indegree[tmp.idx]--;
				if(value > dp[tmp.idx]) {
					dp[tmp.idx]= value; 
				}
				if (indegree[tmp.idx] == 0) {
					queue.add(tmp.idx);
					dp[tmp.idx] += D[tmp.idx]; 
				}
			}
		}
	}
}
