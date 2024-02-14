import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long attack = Long.parseLong(st.nextToken());
		long[] as = new long[n];
		long[] hs = new long[n];

		long tmpAttack = attack;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long t = Long.parseLong(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			long h = Long.parseLong(st.nextToken());
			// 몬스터
			if (t == 1) {
				long count = h / tmpAttack;
				if (h % tmpAttack == 0) {
					count--;
				}
				as[i] = count * a;
			} else {
				tmpAttack += a;
				hs[i] = h;
			}
		}

		long lower = 0,upper = Long.MAX_VALUE - 1;
		while (lower < upper) {
			long mid = (lower + upper) / 2;
//			System.out.println(lower + ", " + upper + " -> " + mid);

			long tmp = mid;
			for (int i = 0; i < n; i++) {
//				System.out.println(tmp);
				if (as[i] == 0) {
					tmp += hs[i];
					if (tmp > mid) {
						tmp = mid;
					}
				} else {
					tmp -= as[i];
				}

				if (tmp <= 0) {
					break;
				}
			}

//			System.out.println(tmp + " 결고ㅏ");
			if (tmp <= 0) {
				lower = mid + 1;
			} else {
				upper = mid;
			}
		}

		System.out.println(lower);

	}
}
