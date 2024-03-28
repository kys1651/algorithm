import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static Point[] spot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			spot = new Point[N + 2];

			// Input
			for (int i = 0; i <= N + 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				spot[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

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
		boolean[] visit = new boolean[N + 1];
		queue.add(spot[0]);
		while (!queue.isEmpty()) {
			Point c = queue.poll();

			if (getDist(c, spot[N + 1]) <= 1000) {
				return true;
			}

			for (int i = 1; i <= N; i++) {
				if (visit[i])
					continue;
				if (getDist(c, spot[i]) <= 1000) {
					visit[i] = true;
					queue.add(spot[i]);
				}
			}
		}
		return false;
	}

	private static int getDist(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}
