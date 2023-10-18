import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int[] units = {2,3,5,7,11};
		int[] result;
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int N = sc.nextInt();
            result = new int[5];
			for(int i = 0; i < 5; i++){
                while(N % units[i] == 0){
                    N /= units[i];
                    result[i]++;
                }
            }
            System.out.print("#" + tc + " ");
            printArr(result);
		}
	}
    private static void printArr(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
}