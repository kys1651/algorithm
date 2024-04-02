import java.util.*;
import java.io.*;

public class Main {
	static long[] dp = new long[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp[1] = dp[2] = dp[3] = 1;
		for(int i = 4; i <= 100; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T ;tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append('\n');
		}
		System.out.println(sb);
	}
}
