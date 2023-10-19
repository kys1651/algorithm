import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int P, Q, R, S, W, A, B;
        
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            /**
            	P : A의 L당 요금
                Q : B의 R리터 이하 요금
                R : B의 기준
                S : B의 R리터 초과 요금
                W : 종민의 한달 수도 양
            **/
            P = sc.nextInt();
            Q = sc.nextInt();            
            R = sc.nextInt();
            S = sc.nextInt();            
            W = sc.nextInt();
            A = W * P;
            B = Q + (W - R <= 0 ? 0 : W - R) * S;
            System.out.printf("#%d %d\n",tc, A < B ? A : B);
		}
	}
}