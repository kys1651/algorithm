import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int size = N * 100;
		int[] dp = new int[size + 1];

		int[] memory = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}

		int[] cost = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			int m = memory[i];
			int c = cost[i];
			for (int j = size; j >= c; j--) {
				dp[j] = Math.max(dp[j], dp[j - c] + m);
			}
		}
		
		for(int i = 0 ; i <= size; i++) {
			if(dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}
}
