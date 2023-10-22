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
            String line = sc.next();
            int result = line.length() - line.replaceAll("\\(\\)"," ").replaceAll("[(,)]","").length();
			System.out.printf("#%d %d\n",tc,result);
		}
	}
}