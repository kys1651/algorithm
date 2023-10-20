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
            int N = sc.nextInt();
            int result = 0;
            for(int i = -N; i <= N; i++){
                for(int j = -N; j <= N; j++){
                    if( i * i + j * j <= N * N){
                        result++;
                    }
                }
            }
			System.out.printf("#%d %d\n",tc,result);
		}
	}
}