import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int SIZE = 500000;
	static int N, K;
	static boolean[][] pos = new boolean[SIZE + 1][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
			return;
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		pos[N][0] = true;

		int time = 0;
		while (!queue.isEmpty()) {
			time++;
			int count = queue.size();
			int isOdd = time % 2;
			for (int i = 0; i < count; i++) {
				int cur = queue.poll();

				if (cur * 2 <= SIZE && pos[cur * 2][isOdd] == false) {
					pos[cur * 2][isOdd] = true;
					queue.add(cur * 2);
				}
				if (cur + 1 <= SIZE && pos[cur + 1][isOdd] == false) {
					pos[cur + 1][isOdd] = true;
					queue.add(cur + 1);
				}
				if (cur - 1 >= 0 && pos[cur - 1][isOdd] == false) {
					pos[cur - 1][isOdd] = true;
					queue.add(cur - 1);
				}
			}

			int sisterPos = K + (time * (time + 1) / 2);
			// 동생이 범위 밖
			if (sisterPos > SIZE) {
				break;
			}

			if (pos[sisterPos][isOdd]) {
				return time;
			}

		}

		return -1;
	}
}
