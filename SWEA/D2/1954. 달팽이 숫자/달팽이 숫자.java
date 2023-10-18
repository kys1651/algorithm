import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[][] map;
        // 오른쪽 -> 아래 -> 왼쪽 -> 위
        int[] dirX = {0,1,0,-1};
        int[] dirY = {1,0,-1,0};
        
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int N = sc.nextInt();
            map = new int[N][N];
            int num = 1;
            int x = 0;
            int y = 0;
            int d = 0;
            while(num <= N * N){
               map[x][y] = num++;
               int nextX = x + dirX[d];
                int nextY = y + dirY[d];
                if(nextX >= N || nextX < 0 || nextY >= N || nextY < 0 || map[nextX][nextY] != 0){
                    d = (d + 1) % 4;
                }
                x += dirX[d];
                y += dirY[d];
            }
            
            System.out.println("#"+tc);
            for(int [] arr : map){
                for(int n : arr){
                    System.out.print(n + " ");
                }
                System.out.println();
            }
            
		}
	}
}