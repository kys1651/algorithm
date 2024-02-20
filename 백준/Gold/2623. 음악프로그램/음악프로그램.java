import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 노드 - 현재 자신을 가르키는 수를 가지고 있음
	static class Node {
		int idx;
		Node next;

		public Node(int idx, Node next) {
			this.idx = idx;
			this.next = next;
		}
	}

	static int N; // 노드의 개수
	static Node[] graph; // 그래프
	static int[] outDegree, result; // 진출차수와 결과 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// Input
		result = new int[N];
		outDegree = new int[N + 1];
		graph = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());

			int prev = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k - 1; j++) {
				int cur = Integer.parseInt(st.nextToken());
				// 현재 그래프에는 자신을 가르키는 노드들을 저장함
				graph[prev] = new Node(cur, graph[prev]);
				// 가르키는 숫자의 진출차수를 올려준다.
				outDegree[cur]++;
				prev = cur;
			}
		}

		// false면 사이클이 있다는 뜻
		if (!topologicalSort()) {
			System.out.println(0);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append('\n');
		}
		System.out.println(sb);
	}

	private static boolean topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();
		// 진출 차수가 0인 노드 큐에 삽입 - 우선 순위기 때문에
		for (int i = 1; i <= N; i++) {
			if (outDegree[i] == 0) {
				queue.add(i);
			}
		}

		for (int i = 0; i < N; i++) {
			// 전체를 방문하기전에 큐가 빈다면 사이클이 있는 것
			if (queue.isEmpty()) {
				return false;
			}

			int x = queue.poll();
			result[i] = x;
			for (Node tmp = graph[x]; tmp != null; tmp = tmp.next) {
				if (--outDegree[tmp.idx] == 0) {
					queue.add(tmp.idx);
				}
			}
		}
		return true;
	}
}
