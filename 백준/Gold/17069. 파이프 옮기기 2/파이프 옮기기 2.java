import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	// 파이프 배열
	static class Pipe {
		long vertical; // 수직으로 올 수 있는 경우
		long horizon; // 수평으로 오는 경우
		long diag; // 대각으로 오는 경우

		public Pipe(int vertical, int horizon, int diag) {
			this.vertical = vertical;
			this.horizon = horizon;
			this.diag = diag;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Pipe[][] map = new Pipe[N + 1][N + 1];

		// Input
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				// 벽이 아니라면 설치
				if (st.nextToken().equals("0")) {
					map[i][j] = new Pipe(0, 0, 0);
				}
			}
		} // Input End

		map[1][2].horizon = 1; //처음에는 가르로 파이프가 차지함
		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				Pipe cur = map[i][j];
				// 널이면 넘어간다.
				if (cur == null)
					continue;
				// 대각선으로 올 수 있는 경우는 위와 왼쪽도 널이 아니여야한다.(벽이 아니여야함)
				if (map[i - 1][j - 1] != null && map[i - 1][j] != null && map[i][j - 1] != null) {
					cur.diag += map[i - 1][j - 1].diag + map[i - 1][j - 1].horizon + map[i - 1][j - 1].vertical;
				}
				// 위가 벽이 아니라면 위에서 오는 경우는 위에 대각선으로 도착하는 경우, 수직으로 오는 경우
				if (map[i - 1][j] != null) {
					cur.vertical += map[i - 1][j].vertical + map[i - 1][j].diag;
				}
				// 왼쪽이 벽이 아니라면 왼쪽으로 대각선으로 도착하는 경우, 대각으로 가는경우다.
				if (map[i][j - 1] != null) {
					cur.horizon += map[i][j - 1].horizon + map[i][j - 1].diag;
				}
			}
		}
		Pipe p = map[N][N];
		// 마지막이 널이라면 0 출력
		if(p == null) {
			System.out.println(0);
		}else {
			System.out.println(p.diag + p.horizon + p.vertical);
		}
	}
}
