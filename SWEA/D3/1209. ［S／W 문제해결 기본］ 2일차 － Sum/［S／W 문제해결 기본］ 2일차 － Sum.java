import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10,SIZE=100;
        int[][] map;
        
		for(int tc = 1; tc <= T; tc++)
		{
            br.readLine();
            map = new int[SIZE][SIZE];
            StringTokenizer st;
            for(int i = 0; i < SIZE; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < SIZE; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 0,crossR = 0, crossL = 0;
            for(int i = 0; i < SIZE ; i++){
                int row = 0,col = 0;
                for(int j = 0; j < SIZE; j++){
                    row += map[i][j];
                    col += map[j][i];
                    if(i == j){
                        crossR += map[i][j];
                        crossL += map[i][SIZE - j - 1];
                    }
                }
                result = Math.max(result, Math.max(row,col));
            }
            result = Math.max(result, Math.max(crossR,crossL));
            System.out.println("#"+tc+" " + result);
		}
	}
}