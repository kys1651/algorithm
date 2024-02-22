import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Node {
		int idx;
		Node next;

		public Node(int idx, Node next) {
			this.idx = idx;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			boolean[] visit = new boolean[101];
			Node[] nodes = new Node[101];

			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nodes[from] = new Node(to, nodes[from]);
			}

			Queue<Integer> queue = new LinkedList<>();
			queue.add(start);
			visit[start] = true;
			int max = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				max = 0;
				for (int i = 0; i < size; i++) {
					int cur = queue.poll();
					max = Math.max(max, cur);
					for (Node tmp = nodes[cur]; tmp != null; tmp = tmp.next) {
						if (visit[tmp.idx])
							continue;
						visit[tmp.idx] = true;
						queue.add(tmp.idx);
					}
				}
			}
			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb);
	}

}
