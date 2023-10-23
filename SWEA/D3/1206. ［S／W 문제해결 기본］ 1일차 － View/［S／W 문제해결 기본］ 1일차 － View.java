import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[] arr;
        
        int T = 10;
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            long result = 0;
            for(int i = 2; i < n - 2; i++){
                result += Math.max(0,arr[i] - Math.max(Math.max(arr[i-1],arr[i-2]),Math.max(arr[i+1],arr[i+2])));
            }
            System.out.println("#" + tc+ " " + result);
		}
	}
}