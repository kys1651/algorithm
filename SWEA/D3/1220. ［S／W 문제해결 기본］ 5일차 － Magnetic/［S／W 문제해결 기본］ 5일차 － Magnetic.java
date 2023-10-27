import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++)
		{
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            int result = 0;
            for(int i = 0; i < N; i ++){
                for(int j = 0; j < N; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i = 0; i < N; i++){
                int count = 0;
                for(int j = 0; j < N; j++){
                    if(map[j][i] == 1) count++;
                    if(map[j][i] == 2 && count != 0){result++;count = 0;}
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
