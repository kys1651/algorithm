import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Bc {
		int x;
		int y;
		int c;
		int p;

		public Bc(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

	static class Person {
		int x;
		int y;
		PriorityQueue<Bc> queue;

		public Person(int x, int y) {
			this.x = x;
			this.y = y;
			queue = new PriorityQueue<>((o1, o2) -> o2.p - o1.p);
		}

		public void move(int n) {
			x += dirX[n];
			y += dirY[n];
		}

		public void getBc() {
			queue.clear();
			for (int i = 0; i < K; i++) {
				if (isIn(x, y, bcs[i])) {
					queue.add(bcs[i]);
				}
			}
		}
	}

	static int[] dirX = { 0, 0, 1, 0, -1 };
	static int[] dirY = { 0, -1, 0, 1, 0 };

	static Person A = new Person(1,1), B = new Person(10,10);
	static Bc[] bcs;
	static int M, K, result;
	static int[] moveA, moveB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			result = 0;
			A.x = 1;
			A.y = 1;
			B.x = 10;
			B.y = 10;

			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			moveA = new int[M + 1];
			moveB = new int[M + 1];

			K = Integer.parseInt(st.nextToken());
			bcs = new Bc[K];

			// A Input
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}

			// B Input
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			// BC Input
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				bcs[i] = new Bc(x, y, c, p);
			}

			start();

			sb.append(String.format("#%d %d\n", tc, result));
		}

		System.out.println(sb);
	}

	private static void start() {
		for (int i = 0; i <= M; i++) {
			// Move
			A.move(moveA[i]);
			B.move(moveB[i]);

			A.getBc();
			B.getBc();

			if (A.queue.isEmpty() && B.queue.isEmpty()) {
				continue;
			}

			getCharge();
		}
	}

	private static void getCharge() {
		if (A.queue.isEmpty()) {
			result += B.queue.poll().p;
			return;
		}

		if (B.queue.isEmpty()) {
			result += A.queue.poll().p;
			return;
		}

		Bc bcA = A.queue.poll();
		Bc bcB = B.queue.poll();

		if (bcA != bcB) {
			result += bcA.p + bcB.p;
			return;
		}

		int tmp = 0;
		if (A.queue.isEmpty() && B.queue.isEmpty()) {
			tmp += (bcA.p / 2) * 2;
		} else if (A.queue.isEmpty()) {
			tmp += B.queue.poll().p + bcA.p;
		} else if (B.queue.isEmpty()) {
			tmp = A.queue.poll().p + bcB.p;
		} else {
			if (A.queue.peek().p > B.queue.peek().p) {
				tmp = A.queue.poll().p + bcB.p;
			} else {
				tmp = B.queue.poll().p + bcA.p;
			}
		}

		result += tmp;
	}

	private static boolean isIn(int x, int y, Bc bc) {
		return (Math.abs(x - bc.x) + Math.abs(y - bc.y)) <= bc.c;
	}
}
