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
            long a = 0;
            long b = 0;
            
            if(isPrime(N)){
                a = 1;
                b = N;
            }else{
                    for(int i = 1; i <= Math.sqrt(N); i++){
                        if(N % i == 0){
                            a = i;
                            b = N / i;
                        }
                    }
            }        
            System.out.println("#" + tc +" " + (a+b-2));
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