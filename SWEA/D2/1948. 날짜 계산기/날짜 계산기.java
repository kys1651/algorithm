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
            int m1 = sc.nextInt();
            int d1 = sc.nextInt();
            int m2 = sc.nextInt();
            int d2 = sc.nextInt();
            int A = addDays(m1) + d1;
            int B = addDays(m2) + d2;
            System.out.printf("#%d %d\n",tc,B - A + 1);
		}
	}
    private static int addDays(int m){
		int[] days = {0,31, 28,31,30,31,30,31,31,30,31,30};
        int day = 0;
        for(int i = 0; i < m; i++){
                day += days[i];
        }
        return day;
    }
}