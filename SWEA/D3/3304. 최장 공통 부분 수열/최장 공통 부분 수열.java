import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            String a = sc.next();
            String b = sc.next();
            int[][] dp = new int[a.length()+1][b.length() + 1];
            for(int i = 1; i <= a.length(); i++){
                for(int j = 1; j <= b.length(); j++){
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            System.out.println("#" + tc + " " + dp[a.length()][b.length()]);
		}
	}
}