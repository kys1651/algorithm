import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
        int M,s,result;
		for(int tc = 1; tc <= T; tc++)
		{
            int N = sc.nextInt();
            result = 0; // 총 이동한 결과
            M = 0; // 속도
            
            for(int i = 0; i < N; i++){
                int C = sc.nextInt();
                if(C != 0){
                    s = sc.nextInt();
                    M = (C == 1) ? M + s : M - s;
                    if(M < 0) M = 0;
                }
                result += M;
            }
            System.out.printf("#%d %d\n",tc,result);
		}
	}
}