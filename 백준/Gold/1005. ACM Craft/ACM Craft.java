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
		Node next;

		public Node(int idx, Node next) {
			this.idx = idx;
			this.next = next;
		}
	}

	static int N, K;
	static int[] D,dp;
	static Node[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			dp = new int[N + 1];
			Arrays.fill(dp, -1);

			// 걸리는 시간 Input
			D = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}// Input End

			// graph Input
			graph = new Node[N + 1];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				graph[end] = new Node(start, graph[end]);
			}// graph Input End
			
			int W = Integer.parseInt(br.readLine());
			sb.append(solve(W)).append('\n');
		}
		System.out.println(sb);
	}

	private static int solve(int x) {
		if(dp[x] != -1) {
			return dp[x];
		}
		int ret = 0;
		for(Node tmp = graph[x]; tmp != null; tmp = tmp.next) {
			ret = Math.max(ret, solve(tmp.idx));
		}
		ret += D[x];
		return dp[x] = ret;
	}
}
