import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int[] boxes;
		int SIZE = 100;
		int T = 10;
		for(int tc = 1; tc <= T; tc++)
		{
            int dumpCount = sc.nextInt();
            boxes = new int[100];
            for(int i = 0; i < SIZE;i++){
                boxes[i] = sc.nextInt();
            }
            while( dumpCount-- > 0){
                Arrays.sort(boxes);
                boxes[0]++;
                boxes[99]--;
            }
                Arrays.sort(boxes);
            System.out.println("#" + tc + " " + (boxes[99] - boxes[0]));
		}
	}
}