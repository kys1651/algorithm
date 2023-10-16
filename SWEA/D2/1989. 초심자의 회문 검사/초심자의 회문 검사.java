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
            String word = sc.next();
            StringBuilder sb = new StringBuilder(word);
            String reverseWord = sb.reverse().toString();
            
            boolean check = true;
            if(!word.equals(reverseWord)){
                check = false;
            }
            System.out.printf("#%d %d\n",tc,check==true?1:0);
        }
	}
}