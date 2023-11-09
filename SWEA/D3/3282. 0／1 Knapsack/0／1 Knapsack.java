import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] weight = new int[n+1];
            int[] cost = new int[n+1];
            
            for(int i = 1; i <= n; i++){
                weight[i] = sc.nextInt();
                cost[i] = sc.nextInt();
            }
            int[][] dp = new int[n+1][k+1];
            for(int i = 1; i <= n; i++){
                for(int j =1; j <= k; j++){
                    if(weight[i] > j){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[ i ][ j ] = Math.max(dp[ i - 1 ][ j - weight [ i ] ] + cost[i]
                                                , dp[ i - 1 ][ j ] );
                    }
                }
            }
            System.out.println("#" + tc + " " + dp[n][k]);
		}
    }
}