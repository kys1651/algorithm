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
			int h1 = sc.nextInt();
            int m1 = sc.nextInt();
            int h2 = sc.nextInt();
            int m2 = sc.nextInt();
            
            int resultM = m1 + m2;
            int resultH = h1 + h2 + (resultM / 60);
            resultM %= 60;
            resultH -= resultH > 12? 12 : 0;
			System.out.printf("#%d %d %d\n",tc,resultH, resultM);
		}
	}
}