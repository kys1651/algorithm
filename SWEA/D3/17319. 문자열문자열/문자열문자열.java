import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        String result = "";
        
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int N = sc.nextInt();
            String S = sc.next();
            
            if(N%2 != 0){
                result = "No";
            }
            else{
                int len = N / 2;
                result = S.substring(0,len).equals(S.substring(len)) ? "Yes" : "No";
            }
            System.out.printf("#%d %s\n",tc,result);
		}
	}
}