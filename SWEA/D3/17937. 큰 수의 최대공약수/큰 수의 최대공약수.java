import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
            BigInteger A = sc.nextBigInteger();
            BigInteger B = sc.nextBigInteger();;
            
            BigInteger gcd = A;
            if(!A.equals(B)){
                gcd = GCD(A,B);
            }
            
            System.out.println("#" + tc + " " + gcd);
		}
    }
    
    private static BigInteger GCD(BigInteger A, BigInteger B){
        BigInteger result = A;
        BigInteger One = new BigInteger("1");
        
        while(A.compareTo(B)  <= 0){

            result = result.gcd(A);
            if(result.equals(One)){
                return One;
            }
            A = A.add(One);
        }
        return result;
    }
    
}