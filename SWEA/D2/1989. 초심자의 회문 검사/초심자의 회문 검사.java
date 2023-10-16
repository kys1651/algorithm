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
            boolean check = true;
            // 0 1 2 3 4 len = 5; len/2 = 2
            // 0 == 5 - 0 - 1(4) == true
            // 1 == 5 - 1 -1(3) == true
            
            // 0 1 2 len = 3 len / 2 -> 1
            // 0 == 3 - 0 - 1(2) == true
            // 
            for(int i = 0; i < word.length() / 2; i++){
                char front = word.charAt(i);
                char rear = word.charAt(word.length() - i - 1);
				if(front != rear){
	                check = false;
                    break; 
                }
            }
            
            System.out.printf("#%d %d\n",tc,check==true?1:0);
        }
	}
}