import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int dp[] = new int[n + 1];
            dp[0] = 0;
            for(int i = 1; i <= n; i++){
                int tmp = sc.nextInt();
                dp[i] = Math.max(dp[i-1] + tmp,dp[i-1] * tmp);
            }
            System.out.println("#" + tc + " " + dp[n]);
		}
	}
}