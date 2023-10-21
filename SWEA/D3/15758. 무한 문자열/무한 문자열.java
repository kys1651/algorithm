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
            String a = sc.next();
            String b = sc.next();
            System.out.print("#" + tc +" ");
            if((a+b).equals(b+a)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
		}
	}
}
    
