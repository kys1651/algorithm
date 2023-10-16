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
            for(int i = 1; i <= line.length(); i++){
                String tmp1 = line.substring(0,i);
				String tmp2 = line.substring(i, i + i);
                if(tmp1.equals(tmp2)){
                	System.out.printf("#%d %d\n",tc,tmp1.length());
                    break;
                }
            }
            
		}
	}
}