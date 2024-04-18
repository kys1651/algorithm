import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = null;
		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input.trim());
			int[] LIS = new int[N];
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (i == 0) {
					LIS[count++] = tmp;
				} else {
					if (LIS[count - 1] < tmp) {
						LIS[count++] = tmp;
					} else if (LIS[0] > tmp) {
						LIS[0] = tmp;
					} else {
						LIS[search(0, count - 1, LIS, tmp)] = tmp;
					}
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	private static int search(int l, int r, int[] LIS, int value) {
		while (l <= r) {
			int m = (l + r) >> 1;
			if (LIS[m] > value) {
				r = m - 1;
			} else if (LIS[m] < value) {
				l = m + 1;
			} else {
				return m;
			}
		}
		return l;
	}
}
