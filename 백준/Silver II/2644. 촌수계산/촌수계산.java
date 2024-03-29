import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, start, end;
	static ArrayList<Integer>[] graph;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1];

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}

//		dfs(start, 0);
		bfs();
		System.out.println(-1);
	}

	private static void dfs(int cur, int count) {
		if (cur == end) {
			System.out.println(count);
			System.exit(0);
		}
		visit[cur] = true;
		for (int next : graph[cur]) {
			if (visit[next])
				continue;
			dfs(next, count + 1);
		}
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start,0});
		visit[start] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if(cur[0] == end) {
				System.out.println(cur[1]);
				System.exit(0);
			}
			
			for(int next : graph[cur[0]]) {
				if(visit[next]) continue;
				
				visit[next] = true;
				queue.add(new int[] {next,cur[1] + 1});
			}
		}
	}
}
