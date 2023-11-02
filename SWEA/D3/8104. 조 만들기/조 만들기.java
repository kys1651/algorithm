import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] num = new int[n+1][k+1];
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= k; j++){
                    if(i % 2 == 0){
                        num[i][k - j + 1] = (i - 1) * k + j;
                    }else{
                        num[i][j] = (i - 1) * k + j;
                    }
                }
            }
            for(int i = 1; i <= k; i++){
                int sum = 0;
                for(int j =1; j <= n ; j++){
                    sum += num[j][i];
                }
                sb.append(sum).append(" ");
            }
            
            System.out.println("#" + tc + " " + sb.toString());
        }
	}
}