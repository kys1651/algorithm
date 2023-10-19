import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Set<Integer> set;
        
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int count = 0;
            set = new HashSet<>();
            
            while(set.size()!=10){
                count++;
                int tmp = N * count;
                while(tmp != 0){
                    set.add(tmp % 10);
                    tmp /= 10;
                }
            }
            
            System.out.printf("#%d %d\n",tc,count * N);
		}
	}
}