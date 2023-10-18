import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[][] map;
        int T=sc.nextInt();;
	
        
		for(int tc = 1; tc <= T; tc++)
		{
            int N = sc.nextInt();
            map = new int[N][N];
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            
            System.out.println("#" + tc);
            printArray(map);
		}
	}
    
    private static void printArray(int[][] arr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            for(int a = arr.length - 1; a >= 0; a--){
                sb.append(arr[a][i]);
            }
            sb.append(" ");
            
            for(int b = arr.length -1; b >= 0; b --){
                sb.append(arr[arr.length - 1 - i][b]);
            }
            sb.append(" ");

 			for(int c = 0; c < arr.length ; c++){
                sb.append(arr[c][arr.length - 1 - i]);
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
}