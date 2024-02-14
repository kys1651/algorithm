import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] num = new int[n];

		long upper = 0, lower = 1;
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if (num[i] > upper)
				upper = num[i];
		}

		// 홀수인 경우를 대비하여 1을 증가시켜줌
		upper++;
		long mid,tmp;
		while (lower < upper) {
			mid = (upper + lower) >> 1;

			tmp = 0;
			for (int number:num) {
				tmp += (number / mid);
			}

			// tmp가 k보다 크다면 너무 조금 자른 것
			if (tmp >= k) {
				lower = mid + 1;
			}
			// tmp가 k보다 작다면 너무 크게 자른 것
			else if (tmp < k) {
				upper = mid;
			}
		}
		System.out.println(lower - 1);
	}
}
