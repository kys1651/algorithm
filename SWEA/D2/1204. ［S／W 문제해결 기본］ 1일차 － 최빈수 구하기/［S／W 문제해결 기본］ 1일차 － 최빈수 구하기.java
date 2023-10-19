import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map;
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int why = sc.nextInt();
            map = new HashMap<>();
            int maxKey = 0;
            for(int i = 0; i < 1000; i++){
                int N = sc.nextInt();
                map.put(N, map.getOrDefault(N,0)+1);
                
                // N의 빈도수
                int currentValue = map.get(N);
                // 현재 가장 높은 빈도수
                int maxValue = map.getOrDefault(maxKey,0);
                
                if(currentValue > maxValue){
                    maxKey = N;
                }else if(currentValue == maxValue){
                    maxKey = Math.max(N, maxKey);
                }
            }
            System.out.printf("#%d %d\n",tc,maxKey);
		}
	}
}