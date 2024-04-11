import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Planet {
		int idx;
		int x;
		int y;
		int z;

		public Planet(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}

	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static Planet[] planets;
	static int N;
	static int[] rank, parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		planets = new Planet[N];

		// Input
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planets[i] = new Planet(i, x, y, z);
		} // Input End

		getEdge();
		init();

		int answer = 0;
		int count = 0;
		while (true) {
			Edge e = pq.poll();
			if (!union(e.from, e.to)) {
				continue;
			}
			answer += e.weight;
			if (++count == N - 1) {
				break;
			}
		}

		System.out.println(answer);
	}

	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;

		if (rank[a] > rank[b]) {
			rank[a] += rank[b];
			parents[b] = a;
		} else {
			rank[b] += rank[a];
			parents[a] = b;
		}
		return true;
	}

	private static void init() {
		rank = new int[N];
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			rank[i] = 1;
			parents[i] = i;
		}
	}

	private static void getEdge() {
		Arrays.sort(planets, (o1, o2) -> o1.x - o2.x);
		for (int i = 0; i < N - 1; i++) {
			pq.add(new Edge(planets[i].idx, planets[i + 1].idx, Math.abs(planets[i].x - planets[i + 1].x)));
		}

		Arrays.sort(planets, (o1, o2) -> o1.y - o2.y);
		for (int i = 0; i < N - 1; i++) {
			pq.add(new Edge(planets[i].idx, planets[i + 1].idx, Math.abs(planets[i].y - planets[i + 1].y)));
		}

		Arrays.sort(planets, (o1, o2) -> o1.z - o2.z);
		for (int i = 0; i < N - 1; i++) {
			pq.add(new Edge(planets[i].idx, planets[i + 1].idx, Math.abs(planets[i].z - planets[i + 1].z)));
		}
	}
}
