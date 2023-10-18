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
                // 오른쪽으로 가다가 벽 만나거나 이미 방문함
                if(d == 0 && (y == N - 1 || map[x][y+1] != 0)){
                    d++;
                }
                // 아래로 가다가 벽 만나거나 이미 방문함
                else if(d == 1 && ( x == N -1 || map[x +1][y] != 0)){
                    d++;
                }
                // 왼쪽으로 가다가 벽 or 방문
                else if(d == 2 && ( y == 0 || map[x-1][y] != 0)){
                    d++;
                }
                // 위로 가다가 방문한 곳
                else if(d == 3 && map[x-1][y] != 0){
                    d = 0;
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