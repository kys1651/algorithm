import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
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
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V;
	static int[] parents;
	static int[] rank;
	static Edge[] edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			make();
			
			edgeList = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(from, to, weight);
			}
			Arrays.sort(edgeList);

			
			int count = 0;
			long weight = 0;
			for (Edge edge : edgeList) {
				if (!union(edge.from, edge.to))
					continue;
				weight += edge.weight;
				if (++count == V)
					break;
			}

			sb.append('#').append(tc).append(' ').append(weight).append('\n');
		}
		System.out.println(sb);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;
		if(rank[a] > rank[b]) {
			parents[b] = a;
			rank[a] += rank[b];
		}else {
			parents[a] = b;
			rank[b] += rank[a];
		}
		
		return true;
	}

	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		parents = new int[V + 1];
		rank = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
			rank[i] = 1;
		}
	}
}
