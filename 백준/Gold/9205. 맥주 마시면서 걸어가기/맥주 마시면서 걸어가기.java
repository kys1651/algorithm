import java.io.*;
import java.util.*;

public class Main{
	// 위치를 저장하는 클래스
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N; // 편의점 개수
	static Point[] spot; // 위치를 저장하는 배열

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		int T = read();
		while (T-- > 0) {
			N = read();
			spot = new Point[N + 2];
			// Input
			for (int i = 0; i <= N + 1; i++) {
				spot[i] = new Point(read(), read());
			}// Input End

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

			// 페스티벌 갈 수 있다면 들어간다.
			if (getDist(c, spot[N + 1]) <= 1000) {
				return true;
			}

			// 편의점을 중간에 확인해준다. 방문했다면 넘어감
			for (int i = 1; i <= N; i++) {
				if (visit[i])
					continue;
				// 갈 수 있는 거리라면 간다.
				if (getDist(c, spot[i]) <= 1000) {
					visit[i] = true;
					queue.add(spot[i]);
				}
			}
		}

		// 못간다면 false return
		return false;
	}
	
	// 맨해튼 거리
	private static int getDist(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
    static int read() throws Exception {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32)
                return isNegative ? n * -1 : n;
            else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
    }
}
