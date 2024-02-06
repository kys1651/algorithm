import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] snack = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(snack);

			int left = 0, right = n - 1;
			int sum = -1;
			while (left < right) {
				int tmp = snack[left] + snack[right];
				if (tmp < m) {
					if (sum < tmp)
						sum = tmp;
					left++;
				} else if (tmp == m) {
					sum = m;
					break;
				} else {
					right--;
				}
			}
			sb.append(String.format("#%d %d\n", tc, sum));
		}
		System.out.println(sb);
	}
}
