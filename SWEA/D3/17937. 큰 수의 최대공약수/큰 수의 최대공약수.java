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
            String A = sc.next();
            String B = sc.next();
            
            System.out.println("#" + tc + " " + (A.equals(B)? A : "1"));
		}
    }
}