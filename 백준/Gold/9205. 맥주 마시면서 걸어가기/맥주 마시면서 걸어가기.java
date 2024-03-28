import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return getDist(cur, this) - getDist(cur, o);
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	static int N;
	static Point cur, end;
	static Point[] marts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			marts = new Point[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			cur = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				marts[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			if (bfs()) {
				sb.append("happy");
			} else {
				sb.append("sad");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static boolean bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[] visit = new boolean[N];
		queue.add(cur);
		while (!queue.isEmpty()) {
			Point c = queue.poll();

			if (getDist(c, end) <= 1000) {
				return true;
			}

			for (int i = 0; i < N; i++) {
				if (visit[i])
					continue;
				if (getDist(c, marts[i]) <= 1000) {
					visit[i] = true;
					queue.add(marts[i]);
				}
			}
		}
		return false;
	}

	private static int getDist(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}
