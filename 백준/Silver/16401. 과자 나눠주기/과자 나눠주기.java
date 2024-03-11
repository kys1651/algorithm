import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int nums[];
	static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// Input
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		} // Input End
		Arrays.sort(nums);

		long left = 1, right = nums[N - 1] + 1;
		while (left < right) {
			long mid = (left + right) / 2;

			// 가능하다면 길이를 더 키워줌
			if (isCan(mid)) {
				left = mid + 1;
			}
			// 부족하다면
			else {
				right = mid;
			}
		}
		System.out.println(left - 1);
	}

	private static boolean isCan(long value) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (value <= nums[i]) {
				count += nums[i] / value;
				if (count >= M) {
					return true;
				}
			}
		}
		return false;
	}
}
