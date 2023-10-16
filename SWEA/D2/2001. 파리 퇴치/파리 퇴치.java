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
            int m = sc.nextInt();
            
            int[][] board = new int[n][n];
            for(int i =0; i < n; i++){
            	for(int j = 0; j < n ;j++){
                	board[i][j] = sc.nextInt();
                }
            }
            
            int max = 0;
            for(int i = 0 ; i < n - m + 1; i++){
                for(int j = 0; j < n - m + 1; j++){
                    int tmp = 0;
                	for(int x = 0; x < m; x++){
                    	for(int y = 0 ; y < m; y++){
                            tmp += board[i + x][j + y];
                        }
                    }
                    max = Math.max(max,tmp);
                }
            }
            System.out.printf("#%d %d\n",tc,max);
        }
	}
}