import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	static Node[] friends;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		friends = new Node[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			friends[from] = new Node(to, friends[from]);
			friends[to] = new Node(from, friends[to]);
		}

		for (int i = 1; i < N; i++) {
			visit[i] = true;
			permutation(0, i, 0);
			visit[i] = false;
		}
		
		System.out.println(0);
	}

	private static void permutation(int depth, int at, int count) {
		if (count == 4) {
			System.out.println(1);
			System.exit(0);
		}

		for (Node tmp = friends[at]; tmp != null; tmp = tmp.next) {
			if (visit[tmp.idx])
				continue;
			visit[tmp.idx] = true;
			permutation(depth + 1, tmp.idx, count + 1);
			visit[tmp.idx] = false;
		}
	}
}
