import java.util.*;
import java.io.*;

public class Main {
	static class Score {
		int score;
		int count;
		int chance;

		public Score(int score, int count, int chance) {
			this.score = score;
			this.count = count;
			this.chance = chance;
		}
	}

	static int A, B;
	static int[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		bfs();
		if (visit[0][B] > visit[1][B]) {
			System.out.println(visit[1][B]);
		} else {
			System.out.println(visit[0][B]);
		}
	}

	private static void bfs() {
		visit = new int[2][B + 1];
		for (int i = A; i <= B; i++) {
			visit[0][i] = visit[1][i] = i;
		}

		Queue<Score> queue = new LinkedList<>();
		queue.add(new Score(A, 0, 0));
		visit[0][A] = 0;
		while (!queue.isEmpty()) {
			Score cur = queue.poll();

			if (cur.score + 1 <= B && visit[cur.chance][cur.score + 1] > cur.count + 1) {
				visit[cur.chance][cur.score + 1] = cur.count + 1;
				queue.add(new Score(cur.score + 1, cur.count + 1, cur.chance));
			}
			if (cur.score * 2 <= B && visit[cur.chance][cur.score * 2] > cur.count + 1) {
				visit[cur.chance][cur.score * 2] = cur.count + 1;
				queue.add(new Score(cur.score * 2, cur.count + 1, cur.chance));
			}
			if (cur.chance == 0) {
				if (cur.score * 10 <= B && visit[1][cur.score * 10] > cur.count + 1) {
					visit[1][cur.score * 10] = cur.count + 1;
					queue.add(new Score(cur.score * 10, cur.count + 1, 1));
				}
			}
		}
	}
}
