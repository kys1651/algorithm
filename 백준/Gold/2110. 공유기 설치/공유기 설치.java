import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] house;
	static int N, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		// Input
		house = new long[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		} // Input End
		Arrays.sort(house);

		long left = 0, right = house[N - 1];
		long answer = 0;
		while (left <= right) {
			long mid = (right + left) / 2;

			if (getCount(mid) >= C) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(answer);

	}

	private static int getCount(long mid) {
		int count = 1;
		long prev = house[0];
		for (int i = 1; i < N; i++) {
			if (house[i] - prev >= mid) {
				prev = house[i];
				count++;
			}
		}
		return count;
	}
}
