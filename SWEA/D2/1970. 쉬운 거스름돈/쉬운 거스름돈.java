import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        final int[] moneys = {50000, 10000,5000,1000,500,100,50,10};
		int[] answer;
        
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int N = sc.nextInt();
            System.out.println("#" + tc);
            for(int i = 0; i < moneys.length; i++){
                System.out.print(N / moneys[i] + " ");
                N %= moneys[i];
            }
            System.out.println();
		}
	}
}