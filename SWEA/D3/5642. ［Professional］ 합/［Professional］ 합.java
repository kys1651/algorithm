import java.util.Scanner;
class Solution{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] nums = new int[n+1];
            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            int[][] dp = new int[n][2];
            dp[0][0] = dp[0][1] = nums[0];
            for(int i = 1; i < n; i++){
                int current = dp[i-1][0] + nums[i];
                dp[i][1] = Math.max(dp[i-1][1],current);
                if(current <= 0){
                    dp[i][0] = 0;
                }else{
                    dp[i][0] = current;
                }
            }
            System.out.println("#" + tc + " " + dp[n-1][1]);
		}
	}
}