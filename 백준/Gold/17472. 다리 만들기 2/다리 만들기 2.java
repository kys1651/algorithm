import java.io.*;
import java.util.*;

public class Main {
	static int N, M, count;
	static int[] parent, rank;
	static int[][] graph, map;

	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// Input
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j * 2) - '0';

				// 섬인 경우 -1로 설정
				if (map[i][j] == 1) {
					map[i][j] = -1;
				}
			}
		} // Input End

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					dfs(i, j, ++count);
				}
			}
		}

		// 그래프 생성
		graph = new int[count + 1][count + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						if (isIn(i + dirX[d], j + dirY[d])) {
							getDist(i + dirX[d], j + dirY[d], d, 1, map[i][j]);
						}
					}
				}
			}
		} // 그래프 생성 종료

		// 간선리스트 생성
		PriorityQueue<Edge> edgeList = new PriorityQueue<>();
		for (int i = 1; i <= count; i++) {
			for (int j = 1; j <= count; j++) {
				if (graph[i][j] != 0) {
					edgeList.add(new Edge(i, j, graph[i][j]));
				}
			}
		} // 간선 리스트 생성 종료

		makeSet();

		int answer = 0;
		while (count != 1) {
			if (edgeList.isEmpty()) {
				answer = -1;
				break;
			}

			Edge e = edgeList.poll();
			if (!union(e.from, e.to))
				continue;

			answer += e.weight;
			count--;
		}

		System.out.println(answer);
	}

	private static void dfs(int x, int y, int mark) {
		map[x][y] = mark;
		for (int i = 0; i < 4; i++) {
			int nX = x + dirX[i];
			int nY = y + dirY[i];
			if (isIn(nX, nY) && map[nX][nY] == -1) {
				dfs(nX,nY,mark);
			}
		}

	}

	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;

		if (rank[a] > rank[b]) {
			parent[b] = a;
			rank[a] += rank[b];
		} else {
			parent[a] = b;
			rank[b] += rank[a];
		}
		return true;
	}

	// 부모 인덱스를 가르키는 트리 생성
	private static void makeSet() {
		parent = new int[count + 1]; // 부모 배열
		rank = new int[count + 1]; // 수
		for (int i = 1; i <= count; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	private static void getDist(int x, int y, int d, int count, int from) {
		if (map[x][y] == 0 && isIn(x + dirX[d], y + dirY[d])) {
			getDist(x + dirX[d], y + dirY[d], d, count + 1, from);
		}
		if (map[x][y] != from) {
			if (count - 1 <= 1)
				return;
			int to = map[x][y];
			if (graph[from][to] == 0 || graph[from][to] > count - 1) {
				graph[from][to] = graph[to][from] = count - 1;
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
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
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
