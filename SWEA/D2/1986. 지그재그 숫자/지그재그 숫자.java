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
            int n = sc.nextInt();	
            int result = (n / 2) * (-1) + (n % 2) * n;
            System.out.printf("#%d %d\n",tc,result );
		}
	}
}