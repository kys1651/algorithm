import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static long S, result;
	static long[] num;
	static ArrayList<Long> left = new ArrayList<>();
	static ArrayList<Long> right = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		// Input
		num = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Long.parseLong(st.nextToken());
		} // Input End

		// 각 왼쪽 오른쪽 집합에서 나올 수 있는 모든 경우의 수를 저장 후 정렬
		powerSet(0, N / 2, 0, left);
		powerSet(N / 2, N, 0, right);
		Collections.sort(left);
		Collections.sort(right);

		getResult();
		if(S == 0) {
			result--;
		}
		System.out.println(result);
	}

	private static void getResult() {
		int lP = 0, rP = right.size() - 1;
		while (lP < left.size() && rP >= 0) {
			long lv = left.get(lP);
			long rv = right.get(rP);
			long sum = lv + rv;

			if (sum == S) {
				long lc = 0;
				while (lP < left.size() && left.get(lP) == lv) {
					lP++;
					lc++;
				}

				long rc = 0;
				while (0 <= rP && right.get(rP) == rv) {
					rP--;
					rc++;
				}
				result += rc * lc;
			} else if (sum < S) {
				lP++;
			} else {
				rP--;
			}
		}
	}

	private static void powerSet(int depth, int limit, long sum, ArrayList<Long> list) {
		if (depth == limit) {
			list.add(sum);
			return;
		}
		powerSet(depth + 1, limit, sum + num[depth], list);
		powerSet(depth + 1, limit, sum, list);
	}
}
