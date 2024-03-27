import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] LIS = new int[N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (i == 0) {
				LIS[count++] = value;
			} else {
				if (LIS[count - 1] < value) {
					LIS[count++] = value;
				} else if (LIS[0] > value) {
					LIS[0] = value;
				} else {
					LIS[bineary(0, count - 1, LIS, value)] = value;
				}
			}
		}
		System.out.println(count);
	}

	private static int bineary(int left, int right, int[] LIS, int value) {
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (LIS[mid] < value) {
				left = mid + 1;
			} else if (LIS[mid] > value) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return left;
	}
}
