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
            long a = sc.nextLong();
            long b = sc.nextLong();
            
            long oper = maxOper(a,b);
            System.out.printf("#%d %d\n",tc,oper);
		}
	}
    private static long maxOper(long a, long b){
        if(a > b){
            return -1;
        }else if(a == b){
            return 0;
        }
        
        long diff = Math.abs(a - b);
        if(diff == 1){
            return -1;
        }else if(diff % 2 == 0){
            return diff / 2;
        }else{
            return (diff - 1) / 2;
        }
    }
}