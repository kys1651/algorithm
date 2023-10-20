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
            long N = sc.nextInt();
           	long y = 2;
            long x = N + y;
	
            while(isPrime(x) || isPrime(y)){
                x++; 
                y++;
            }
            System.out.println("#" + tc + " " + x + " " + y);
        }
	}
    private static boolean isPrime(long num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}