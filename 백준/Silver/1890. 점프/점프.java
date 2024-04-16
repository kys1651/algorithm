import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// Input
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j * 2) - '0';
				if (map[i][j] == 0)
					map[i][j] = -1;
			}
		} // Input End

		map[N - 1][N - 1] = 0;
		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dp[i][j] == 0 || (i == N - 1 && j == N - 1))
					continue;

				int jump = map[i][j];
				if (i + jump < N && map[i][j] != -1) dp[i + jump][j] += dp[i][j];
				if (j + jump < N && map[i][j] != -1) dp[i][j + jump] += dp[i][j];
			}
		}

		System.out.println(dp[N - 1][N - 1]);
	}
}
