import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
 static int[][] mag = new int[4][8];
	static boolean[] visit = new boolean[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());

			// Input
			for (int i = 0; i < 4; i++) {
				String input = br.readLine();
				for (int j = 0; j < 8; j++)
					mag[i][j] = input.charAt(j * 2) - '0';
			} // Input End

			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int pos = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				visit[0] = visit[1] = visit[2] = visit[3] = false;
				rotate(pos, dir);
			}

			sb.append(String.format("#%d %d\n", tc, getResult()));
		}
		System.out.println(sb);
	}
	private static int getResult() {
		int answer = 0;
		for (int i = 0; i < 4; i++) {
			answer += (1 << i) * mag[i][0];
		}
		return answer;
	}

	private static void rotate(int idx, int cw) {
		visit[idx] = true;
		if (idx != 0 && mag[idx][6] != mag[idx - 1][2] && !visit[idx-1]) {
			rotate(idx - 1, -cw);
		}
		if (idx != 3 && mag[idx][2] != mag[idx + 1][6] && !visit[idx+1]) {
			rotate(idx + 1, -cw);
		}
		if (cw == 1) cw(idx);
		else ccw(idx);
	}

	private static void ccw(int idx) {
		int tmp = mag[idx][0];
		for (int i = 0; i < 7; i++) {
			mag[idx][i] = mag[idx][i + 1];
		}
		mag[idx][7] = tmp;
	}

	private static void cw(int idx) {
		int tmp = mag[idx][7];
		for (int i = 7; i >= 1; i--) {
			mag[idx][i] = mag[idx][i-1];
		}
		mag[idx][0] = tmp;
	}
}
