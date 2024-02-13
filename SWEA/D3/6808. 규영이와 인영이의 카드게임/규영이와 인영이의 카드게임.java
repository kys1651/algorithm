import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: D3_6808_규영이와인영이의 카드 게임
 * 
 * @author 김용수
 * 
 * 접근 방법 
 * 1. 규영이가 내지않은 카드를 찾아서 순열을 구한다. 2. 게임 결과를 출력하면 된다.
 *
 */
public class Solution {
	static int Lose, Win;
	static int[] a, b, c;
	static boolean[] visit;
	static final int K = 9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		a = new int[K];
		b = new int[K];
		c = new int[K];
		for (int tc = 1; tc <= T; tc++) {
			Lose = Win = 0;
			visit = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				visit[a[i]] = true;
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (visit[i])
					continue;
				b[idx++] = i;
			}
			c = new int[K];
			permutation(0);

			sb.append(String.format("#%d %d %d\n", tc, Win, Lose));
		}
		System.out.println(sb);
	}

	private static void permutation(int depth) {
		if (depth == K) {
			getResult();
			return;
		}

		for (int i = 0; i < K; i++) {
			if (visit[b[i]])
				continue;

			visit[b[i]] = true;
			c[depth] = b[i];
			permutation(depth + 1);
			visit[b[i]] = false;
		}
	}

	private static void getResult() {
		int sum = 0;
		for (int i = 0; i < K; i++) {
			int tmp = a[i] + c[i];
			if (a[i] > c[i]) {
				sum += tmp;
			} else {
				sum -= tmp;
			}
		}
		if(sum < 0) {
			Lose++;
		}else {
			Win++;
		}
	}
}
