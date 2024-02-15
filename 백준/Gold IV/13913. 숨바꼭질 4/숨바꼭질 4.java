import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static final int SIZE = 100000;
	static int[] pos = new int[SIZE + 1];

	static int N, K, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();

		sb.append(pos[K] - 1).append('\n');

		int cur = K;
		Stack<Integer> stack = new Stack<>();
		while (pos[cur] != 1) {
			stack.push(cur);
			int now = pos[cur];
			if (cur - 1 >= 0 && pos[cur - 1] == now - 1) {
				cur -= 1;
			} else if (cur + 1 <= SIZE && pos[cur + 1] == now - 1) {
				cur += 1;
			} else if (cur % 2 == 0 && pos[cur / 2] == now - 1) {
				cur /= 2;
			} 
		}
		
		stack.push(N);
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
		System.out.println(sb);
		
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		pos[N] = 1;
		queue.add(N);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (cur == K) {
				return;
			}

			int nextCount = pos[cur] + 1;
			if (cur + 1 <= SIZE && pos[cur + 1] == 0) {
				pos[cur + 1] = nextCount;
				queue.add(cur + 1);
			}
			if (cur - 1 >= 0 && pos[cur - 1] == 0) {
				pos[cur - 1] = nextCount;
				queue.add(cur - 1);
			}
			if (cur * 2 <= SIZE && pos[cur * 2] == 0) {
				pos[cur * 2] = nextCount;
				queue.add(cur * 2);
			}
		}
	}

	private static void answerPrint() {

	}
}
