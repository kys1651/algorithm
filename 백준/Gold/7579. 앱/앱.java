import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int size = N * 100;
		int[][] dp = new int[N + 1][size + 1];

		int[] memory = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cost = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= size; j++) {
				if (j < cost[i])
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]);
			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= size; j++) {
				if (dp[i][j] >= M) {
					result = Math.min(j, result);
				}
			}
		}
		System.out.println(result);
	}
}
