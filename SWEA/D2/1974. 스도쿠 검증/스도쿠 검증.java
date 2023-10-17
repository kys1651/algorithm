import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] map;
        int SIZE = 9;
		for(int tc = 1; tc <= T; tc++)
		{
            map = new int[SIZE][SIZE];
            for(int i = 0; i < SIZE; i++){
            	for(int j = 0; j < SIZE; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            System.out.print("#"+tc +" ");
			if(checkRowCol(map)&&checkSquare(map)){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
    private static boolean checkRowCol(int[][] map){
        for(int i = 0; i < 9; i++){
            int sumRow = 0;
            int sumCol =0;
            for(int j = 0; j < 9; j++){
                sumRow += map[i][j];
                sumCol += map[j][i];
            }
            if(sumRow != 45 || sumCol != 45){
                return false;
            }
        }
        return true;
    }
    
    private static boolean checkSquare(int[][] map){
        for(int i = 0; i < 9; i+= 3){
            for(int j = 0; j < 9 ; j += 3){
                int sum = 0;
                for(int x = 0; x < 3; x++){
                    for(int y = 0 ; y < 3; y++){
                        sum += map[i+x][j+y];
                    }
                }
                if(sum != 45){
                    return false;
                }
            }
        }
        return true;
    }
}
