import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class Hamburger {
		int taste;
		int cal;

		public Hamburger(int taste, int cal) {
			this.taste = taste;
			this.cal = cal;
		}
	}

	static int N, L, result;
	static Hamburger[] hamburgers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			result = -1;

			hamburgers = new Hamburger[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				hamburgers[i] = new Hamburger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			for (int i = 1; i < (1 << N); i++) {
				calculate(i);
			}

			sb.append(String.format("#%d %d\n", tc, result));
		}
		System.out.println(sb);
	}

	private static void calculate(int flag) {
		int calSum = 0;
		int tasteSum = 0;
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) {
				calSum += hamburgers[i].cal;
				tasteSum += hamburgers[i].taste;
			}
			if (calSum > L) {
				return;
			}
		}
		if (result < tasteSum) {
			result = tasteSum;
		}
	}
}
