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
            int idx = 0;
            for(int i = 0; i < line.length(); i++,idx++){
                if(line.charAt(i) != 'a' + idx){
                    break;
            	}
			}
            System.out.println("#" + tc + " " + idx);
		}
    }
}