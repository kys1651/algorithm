import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		makeSet(N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (command.equals("0")) {
				union(a,b);
			} else {
				if (equalSet(a, b)) {
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
		a = findParent(a);
		b = findParent(b);
		if (a == b) {
			return;
		}
		set[b] = a;
	}

	private static boolean equalSet(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		return a == b;
	}

	private static int findParent(int n) {
		if (set[n] == n) {
			return n;
		}
		return set[n] = findParent(set[n]);
	}

	private static void makeSet(int n) {
		set = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			set[i] = i;
		}
	}

}
