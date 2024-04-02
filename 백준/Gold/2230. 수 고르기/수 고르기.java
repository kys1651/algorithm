import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// Input
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		} // Input End
		Arrays.sort(num);
		
		int left = 0, right = 0;
		int min = Integer.MAX_VALUE;
		while (left <= right) {
			int value = num[right] - num[left];
			if (value >= M && min > value) {
				min = value;
			}

			if (right == N - 1 || value > M) {
				left++;
			} else if (value < M) {
				right++;
			} else if (value == M) {
				break;
			}
		}
		System.out.println(min);

	}
}
