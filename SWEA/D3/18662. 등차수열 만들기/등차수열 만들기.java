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
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            double result = (a + c) / 2.0;
            result = Math.abs(result - b);
            System.out.println("#" + tc + " " + result);
            
		}
	}
}