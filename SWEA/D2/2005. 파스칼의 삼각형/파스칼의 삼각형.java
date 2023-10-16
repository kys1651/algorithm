import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int[][] dp = new int[n][n];
            
            dp[0][0] = 1;
			for(int i = 1; i < n; i++){
            	for(int j =0; j <= i; j++){
                    if(j % 2 == 0){
                        dp[i][j] += ( j -1 >= 0) ? dp[i-1][j-1] : 0;
                    	dp[i][j] += dp[i-1][j];
                    }
                    else{
                        dp[i][j] += dp[i-1][j-1];
                        dp[i][j] += dp[i-1][j];
                    }
                }
            }
            
            System.out.printf("#%d \n",tc);
            for(int[] ds : dp){
            	for(int  d : ds){
                    if(d == 0)
                        break;
                	System.out.print(d +" ");
                }
                System.out.println();
            }
            
		}
	}
}