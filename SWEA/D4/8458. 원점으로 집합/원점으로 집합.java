import java.io.*;
import java.util.*;


class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			// 각 원점사이의 거리 Input
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i] = Math.abs(a) + Math.abs(b);
			} // Input End

			long answer = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] % 2 != arr[0] % 2) {
					answer = -1;
					break;
				}
				if (max < arr[i]) {
					max = arr[i];
				}
			}

			if (answer != -1){
				for (;; answer++) {
					long tmp = (answer * (answer + 1)) >> 1;
					if (tmp >= max && (tmp - max) % 2 == 0) {
						break;
					}
				}
			}
			
			sb.append(String.format("#%d %d\n", tc, answer));
		}
		System.out.println(sb);
	}
}