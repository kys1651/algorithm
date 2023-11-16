import java.util.Scanner;
class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n+1][k+1];
        int[] ws = new int[n+1];
        int[] vs = new int[n+1];
        for(int i = 1; i <= n; i++){
            ws[i] = sc.nextInt();
            vs[i] = sc.nextInt();
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if(ws[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], vs[i] + dp[i-1][j-ws[i]]);
                }
            }
        }
        System.out.println(dp[n][k]);
	}
}