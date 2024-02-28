import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Pipe {
		int vertical;
		int horizon;
		int diag;

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
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 0) {
					map[i][j] = new Pipe(0, 0, 0);
				}
			}
		} // Input End

		map[1][2].horizon = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				Pipe cur = map[i][j];
				if (cur == null)
					continue;
				if (map[i - 1][j - 1] != null && map[i - 1][j] != null && map[i][j - 1] != null) {
					cur.diag += map[i - 1][j - 1].diag + map[i - 1][j - 1].horizon + map[i - 1][j - 1].vertical;
				}
				if (map[i - 1][j] != null) {
					cur.vertical += map[i - 1][j].vertical + map[i - 1][j].diag;
				}
				if (map[i][j - 1] != null) {
					cur.horizon += map[i][j - 1].horizon + map[i][j - 1].diag;
				}
			}
		}
		Pipe p = map[N][N];
		if(p == null) {
			System.out.println(0);
		}else {
			System.out.println(p.diag + p.horizon + p.vertical);
		}
	}
}
