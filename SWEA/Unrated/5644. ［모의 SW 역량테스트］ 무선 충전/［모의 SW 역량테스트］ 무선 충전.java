import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Bc [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append(", c=");
			builder.append(c);
			builder.append(", p=");
			builder.append(p);
			builder.append("]");
			return builder.toString();
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

	static Person A, B;
	static Bc[] bcs;
	static int M, K, result;
	static int[] moveA, moveB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			result = 0;
			A = new Person(1, 1);
			B = new Person(10, 10);

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
//			System.out.println(result);
		}

		System.out.println(sb);
	}

	private static void start() {
		for (int i = 0; i <= M; i++) {
			// Move
			A.move(moveA[i]);
			B.move(moveB[i]);

			// 주변 조회
			A.getBc();
			B.getBc();
//			System.out.println("A -> " + A.x + " " + A.y);
//			System.out.println("B -> " + B.x + " " + B.y);
//			System.out.println(A.queue);
//			System.out.println(B.queue);

			Bc bcA = null;
			Bc bcB = null;
			int cA = 0;
			int cB = 0;
			if (!A.queue.isEmpty()) {
				bcA = A.queue.poll();
				cA = bcA.p;
			}
			if (!B.queue.isEmpty()) {
				bcB = B.queue.poll();
				cB = bcB.p;
			}

			if (bcA != null && bcB != null && bcA == bcB) {
				if (A.queue.isEmpty() && B.queue.isEmpty()) {
					cA = cB = cA / 2;
				} else if (A.queue.isEmpty()) {
					cB = B.queue.poll().p;
				} else if (B.queue.isEmpty()) {
					cA = A.queue.poll().p;
				} else {
					if (A.queue.peek().p > B.queue.peek().p) {
						cA = A.queue.poll().p;
					} else {
						cB = B.queue.poll().p;
					}
				}
			}

//			System.out.println(cA + " " + cB);
//			System.out.println();
			result += cA + cB;
		}
	}

	private static boolean isIn(int x, int y, Bc bc) {
		return (Math.abs(x - bc.x) + Math.abs(y - bc.y)) <= bc.c;
	}
}
