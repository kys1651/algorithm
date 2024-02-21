import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] set;
	static int[] rank;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			makeSet();

			sb.append('#').append(tc).append(' ');
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (command == 0) {
					union(a, b);
				} else {
					if (findParent(a, b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static boolean findParent(int a, int b) {
		if (findSet(a) == findSet(b)) {
			return true;
		}
		return false;
	}

	private static int findSet(int n) {
		if (set[n] == n) {
			return n;
		}
		return set[n] = findSet(set[n]);
	}

	private static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if (a == b)
			return;
		set[b] = a;
	}

	private static void makeSet() {
		set = new int[N + 1];
		// [0] - idx값
		// [1] - 부모노드의 번호
		for (int i = 1; i <= N; i++) {
			set[i] = i;
		}
	}
}
