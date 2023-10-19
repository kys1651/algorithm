import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int[] nums;
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int why = sc.nextInt();
            nums = new int[101];

            int maxIdx = 0;
            for(int i = 0; i < 1000; i++){
                int N = sc.nextInt();
                nums[N]++;
                
				int currentValue = nums[N];
                int maxValue = nums[maxIdx];
				                		
                if(currentValue > maxValue){
                    maxIdx = N;
                }else if(currentValue == maxValue){
                    maxIdx = Math.max(N, maxIdx);
                }
            }
            System.out.printf("#%d %d\n",tc,maxIdx);
		}
	}
}