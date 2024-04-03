import java.util.*;
import java.io.*;

class Solution{
	static boolean[][] graph;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			graph = new boolean[N + 1][N + 1];

			// Input
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from][to] = true;
			} // Input End

			int answer = 0;
			for (int i = 1; i <= N; i++) {
				int gt = getGt(i, new boolean[N + 1]);
				int lt = getLt(i, new boolean[N + 1]);
				if (gt + lt == N - 1)
					answer++;
			}
			sb.append(String.format("#%d %d\n", tc, answer));
		}
		System.out.println(sb);
	}

	private static int getLt(int from, boolean[] visit) {
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (!visit[i] && graph[from][i]) {
				visit[i] = true;
				answer += getLt(i, visit) + 1;
			}
		}
		return answer;
	}

	private static int getGt(int to, boolean[] visit) {
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (!visit[i] && graph[i][to]) {
				visit[i] = true;
				answer += getGt(i, visit) + 1;
			}
		}
		return answer;
	}
}