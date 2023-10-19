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
            String result = new String(Base64.getDecoder().decode(line));
            System.out.printf("#%d %s\n",tc,result);
		}
	}
}