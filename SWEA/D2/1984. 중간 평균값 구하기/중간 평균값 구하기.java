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
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            double sum = 0;
            for(int i = 0; i < 10; i++){
                int tmp = sc.nextInt();
            	min = Math.min(min, tmp);
                max = Math.max(max, tmp);
                
                sum += tmp;
            }
            
            sum -= (max + min);
            int avg = (int)Math.round(sum / 8);
            System.out.printf("#%d %d\n",tc,avg);
		}
	}
}