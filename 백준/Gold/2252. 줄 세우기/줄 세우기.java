import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node[] nodes = new Node[N + 1];
		int[] count = new int[N + 1];
		int[] result = new int[N];

		// Input
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			nodes[from] = new Node(to,nodes[from]);
			count[to]++;
		}

		// 0인 것 받기
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				queue.add(i);
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			result[i] = queue.poll();
			for(Node tmp = nodes[result[i]]; tmp != null ; tmp = tmp.next) {
				if(--count[tmp.to]== 0) {
					queue.add(tmp.to);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(' ');
		}
		System.out.println(sb);
	}
}
