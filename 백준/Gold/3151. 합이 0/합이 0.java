import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		// Input
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		} // Input End

		// Sort
		Arrays.sort(nums);

		long answer = 0;
		for (int i = 0; i < N; i++) {
			if (nums[i] > 0)
				break;
			int left = i + 1, right = N - 1;

			while (left < right) {
				int value = nums[left] + nums[right] + nums[i];
				if (value == 0) {
					if (nums[left] == nums[right]) {
						long count = right - left + 1;
						answer = answer + ((count * (count - 1)) >> 1);
						break;
					}
					
					long l = 1, r = 1;
					while (left + 1 < right && nums[left] == nums[left + 1]) {
						l++;
						left++;
					}
					while (right - 1 > left && nums[right] == nums[right - 1]) {
						r++;
						right--;
					}
					answer = answer + r * l;
				}

				if (value <= 0) {
					left++;
				} else if (value > 0) {
					right--;
				}
			}
		}

		System.out.println(answer);
	}
}
