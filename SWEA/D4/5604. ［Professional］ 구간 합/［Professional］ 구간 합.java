import java.util.*;
import java.io.*;

class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long result = solve(a, b);
			sb.append(String.format("#%d %d\n", tc,result));
		}
		System.out.println(sb);
	}

	private static long solve(long start, long end) {
		long[] answer = new long[10];
		long digit = 1;
		while (start <= end) {
			while (end % 10 != 9 && start <= end) {
				add(answer, end, digit);
				end--;
			}
			if (start > end)
				break;

			while (start % 10 != 0 && start <= end) {
				add(answer, start, digit);
				start++;
			}
			
			start /= 10;
			end /= 10;
			
			for(int i = 0; i < 10; i++) {
				answer[i] += (end - start + 1) * digit;
			}
			digit *= 10;
		}
		
		return getResult(answer);
	}

	private static long getResult(long[] answer) {
		long sum = 0;
		for(int i = 1; i < 10; i++) {
			sum += i * answer[i];
		}
		return sum;
	}
	private static void add(long[] answer, long value, long digit) {
		while (value != 0) {
			int pos = (int) (value % 10);
			answer[pos] += digit;
			value /= 10;
		}
	}
}