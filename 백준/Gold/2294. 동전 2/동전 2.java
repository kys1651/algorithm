import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[k+1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE - 1;
        }
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int tmp = sc.nextInt();
            for(int j = tmp; j <= k; j++){
                dp[j] = Math.min(dp[j], dp[j - tmp] + 1);
            }
        }
        System.out.println(dp[k] == Integer.MAX_VALUE - 1 ? "-1" : dp[k]);
    }
}
