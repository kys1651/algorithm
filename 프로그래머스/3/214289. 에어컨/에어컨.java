import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        temperature += 10;
        t1 += 10; 
        t2 += 10;
        
        int[][] dp = new int[onboard.length][51];
        for(int i = 0; i < onboard.length; i ++){
            for(int j = 0; j <= 50; j++){
                dp[i][j] = 100_000;
            }
        }
        
        dp[0][temperature] = 0;
        for(int i = 1; i < onboard.length; i++){
            for(int j = 0; j <= 50; j++){
                if(onboard[i] == 1 && (j < t1 || j > t2)){
                    continue;
                }
                if(j != 0){
                    if(j <= temperature) dp[i][j] = Math.min(dp[i-1][j-1],dp[i][j]);    
                    else dp[i][j] = Math.min(dp[i-1][j-1] + a,dp[i][j]);
                }
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + (temperature == j ? 0 : b));
                if( j != 50 ){
                    if(j >= temperature) dp[i][j] = Math.min(dp[i-1][j+1], dp[i][j]);
                    else dp[i][j] = Math.min(dp[i-1][j+1] + a, dp[i][j]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i <= 50; i++){
            answer = Math.min(answer,dp[onboard.length - 1][i]);
        }
        return answer;
    }
}