import java.util.Scanner;
class Solution{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int[] dp = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }

            dp[0] = nums[0];
            int max = dp[0];
            for(int i = 1; i < n; i++){
                dp[i] = Math.max(dp[i-1] + nums[i] , nums[i]);
                max = Math.max(dp[i], max);
            }
            
            System.out.println("#" + tc + " " + max);
		}
	}
}