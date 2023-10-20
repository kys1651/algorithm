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
            
            System.out.println("#" + tc + " " + (A.equals(B)? A : "1"));
		}
    }
}