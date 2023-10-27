import java.util.Scanner;
import java.util.Stack;

class Solution
{
    static int SIZE = 100;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc <= T; tc++)
		{
            sc.next();
            int[][] map = new int[SIZE][SIZE];
            for(int i = 0; i < SIZE; i ++){
                for(int j = 0; j < SIZE; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            int result = 0;
            for(int i = 0; i < SIZE; i++){
                int count = 0;
                for(int j = 0; j < SIZE; j++){
                    if(map[j][i] == 1) count++;
                    if(map[j][i] == 2 && count != 0){
                        result++;
                        count = 0;
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
