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
            long N = sc.nextLong();
            long result = 0;
            
            if(isPrime(N)){
                result = N - 1;
            }else{
                    for(int i = (int)Math.sqrt(N); i >= 1; i--){
                        if(N % i == 0){
                            result = (i + N / i) -2;
                            break;
                        }
                    }
            }        
            System.out.println("#" + tc + " " + result);
        }
    }
    
    private static boolean isPrime(long N){
        for(int i = 2; i <= Math.sqrt(N); i++){
            if(N % i == 0){
                return false;
            }
        }
        return true;
    }
}