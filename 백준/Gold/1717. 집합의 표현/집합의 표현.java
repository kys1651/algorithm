import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		makeSet(N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (c == 0) {
				union(a, b);
			} else {
				if (find(a) == find(b)) {
					sb.append("YES");
				} else {
					sb.append("NO");
				}
				sb.append('\n');
			}
		}

		System.out.println(sb);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;
		
		if(depth[a] < depth[b]) {
			parent[a] = b;
			depth[b] += depth[a];
		}else {
			parent[b] = a;
			depth[a] += depth[b];
		}
	}

	private static int find(int n) {
		if (parent[n] == n) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	private static void makeSet(int n) {
		parent = new int[n + 1];
		depth = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			depth[i] = 1;
		}
	}

}
