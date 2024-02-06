import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: D3_9229_한빈이와 SpotMart
 * 
 * @author 김용수 실행시간: 153ms 메모리 : 29848kb
 * 
 *         접근 방법: 1. 정렬 후 투포인터를 이용하여 계산을 해준다.
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			// 과자를 담아주는 배열
			int[] snack = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}

			int sum = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					int tmp = snack[i] + snack[j];
					if (tmp <= m && tmp > sum)
						sum = tmp;
				}
			}

			sb.append(String.format("#%d %d\n", tc, sum == 0 ? -1 : sum));
		}
		System.out.println(sb);
	}
}
