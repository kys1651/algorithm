import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int[][] dp = new int[n+1][2];
            int result = 0;
            for(int i = 1; i <= n; i++){
                dp[i][0] = sc.nextInt();
            }
            for(int i = 1; i <=n; i++){
                int maxIdx = 0;
                for(int j = 0; j < i; j++){
                    if(dp[i][0] > dp[j][0] && dp[j][1] > dp[maxIdx][1]) maxIdx = j;
                }
                dp[i][1] = dp[maxIdx][1] + 1;
                result = Math.max(dp[i][1] , result);
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}