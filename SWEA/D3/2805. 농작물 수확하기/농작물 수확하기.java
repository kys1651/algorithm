import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[][] map;
        
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			int n = sc.nextInt();
            map = new int[n][n];
            for(int i = 0; i < n; i++){
                String tmp = sc.next();
                for(int j = 0; j < n; j++){
                    map[i][j] = tmp.charAt(j) - '0';
                }
            }
            
            int mid = n / 2;
            int valid = 1;
            int sum = 0;
            boolean oper = true;
            for(int i = 0; i < n; i++){
                for(int j = 0;  j < valid; j++){
                    sum += map[i][mid + j];
                }
                if(oper){
                    mid --;
                    valid += 2;
                    oper = mid == 0? false: true;
                }else{
                    mid ++;
                    valid -= 2;
                }
            }
            System.out.println("#" +tc + " " + sum);
		}
	}
}