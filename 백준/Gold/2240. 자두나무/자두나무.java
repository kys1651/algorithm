import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[][][] dp = new int[T + 1][W + 1][2];
		for (int i = 1; i <= T; i++) {
			int pos = Integer.parseInt(br.readLine()) + 1;
			dp[i][0][0] = dp[i - 1][0][0];
			dp[i][0][1] = dp[i - 1][0][1];
			if(pos==2) {
				dp[i][0][0]++;
			}
			
			for (int j = 1; j <= W; j++) {
				dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1]);
				dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0]);
				dp[i][j][pos % 2]++;
			}
		}

		int answer = 0;
		for (int i = 0; i <= W; i++) {
			if (answer < dp[T][i][0]) {
				answer = dp[T][i][0];
			}
			if (answer < dp[T][i][1]) {
				answer = dp[T][i][1];
			}
		}

		System.out.println(answer);
	}
}
