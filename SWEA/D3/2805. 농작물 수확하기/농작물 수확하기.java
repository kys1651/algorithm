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
            
            int start = n / 2;
            int end = n / 2;
            int sum = 0;
            for(int i = 0; i < n; i++){
                for(int j = start;  j <= end; j++){
                    sum += map[i][j];
                }
                if(i < n / 2){
                    start--;
                    end++;
                }else{
                    start++;
                    end--;
                }
            }
            System.out.println("#" +tc + " " + sum);
		}
	}
}