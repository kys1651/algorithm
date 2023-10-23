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
            while(dumpCount-->0){
                dump(boxes);
            }
            System.out.println("#" + tc + " "+(dump(boxes)+2));
		}
	}
    private static int dump(int [] boxes){
        int maxIdx = 0;
        int minIdx = 0;
		for(int i = 0; i < boxes.length; i++){
            if(boxes[i] > boxes[maxIdx]){
                maxIdx = i;
            }
            if(boxes[i] < boxes[minIdx]){
                minIdx = i;
            }
        }
        boxes[maxIdx]--;
        boxes[minIdx]++;
        return boxes[maxIdx] - boxes[minIdx];
    }
}