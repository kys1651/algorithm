import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] count = new int[N + 1];
		int[] result = new int[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			count[to]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				queue.add(i);
			}
		}

		for (int i = N-1; i >= 0; i--) {
			if (queue.isEmpty()) {
				System.out.println("Wrong Input");
				return;
			}

			int x = queue.poll();
			result[i] = x;
			for (int to : graph[x]) {
				count[to]--;
				if (count[to] == 0) {
					queue.add(to);
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
