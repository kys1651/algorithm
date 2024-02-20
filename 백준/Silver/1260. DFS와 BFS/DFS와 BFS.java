import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int idx;
		Node next;

		public Node(int idx) {
			this.idx = idx;
		}
		public void insert(Node node) {
			if(idx > node.idx) {
				int tmp = idx;
				idx = node.idx;
				node.idx = tmp;
				node.next = this.next;
				next = node;
			}else if(next == null) {
				next = node;
			}else {
				next.insert(node);
			}
		}
	}

	static int N;
	static Node[] graph;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new Node[N + 1];
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(graph[from] == null) {
				graph[from] = new Node(to);
			}else {
				graph[from].insert(new Node(to));
			}
			if(graph[to] == null) {
				graph[to] = new Node(from);
			}else {
				graph[to].insert(new Node(from));
			}
		}
		
		visit = new boolean[N+1];
		dfs(V);
		
		sb.append('\n');
		visit = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>(); 
		queue.add(v);
		visit[v] = true;
		sb.append(v).append(' ');
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(Node tmp = graph[cur]; tmp != null; tmp = tmp.next) {
				if(visit[tmp.idx]) continue;
				sb.append(tmp.idx).append(' ');
				visit[tmp.idx] = true;
				queue.add(tmp.idx);
			}
		}
	}

	private static void dfs(int cur) {
		visit[cur] = true;
		sb.append(cur).append(' ');
		for(Node tmp = graph[cur]; tmp != null; tmp = tmp.next) {
			if(visit[tmp.idx]) continue;
			dfs(tmp.idx);
		}
	}
}
