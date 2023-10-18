import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[] A;
        int[] B;

        int T=sc.nextInt();;
		for(int tc = 1; tc <= T; tc++)
		{
        	int N = sc.nextInt();
            int M = sc.nextInt();
            A = new int[N];
            B = new int[M];
            for(int i = 0; i < N; i++){
                A[i] = sc.nextInt();
            }
            for(int j = 0; j < M; j++){
                B[j] = sc.nextInt();
            }
            int result = searchMax(N < M ? A : B, N <= M ? B : A );
            System.out.printf("#%d %d\n",tc,result);
		}
	}
    
    private static int searchMax(int[] A, int[] B){
        int max = 0;
        for(int i = 0 ; i <= B.length- A.length; i++){
            int tmp = 0;
            for(int j = 0; j < A.length; j++){
                tmp += A[j] * B[i + j];
            }
            max = Math.max(tmp, max);
        }
        return max;
    }
}