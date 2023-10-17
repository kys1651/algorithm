import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int[] input;

        int T=sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int N = sc.nextInt();
        	input = new int[N];    
            for(int i = 0; i < N; i++){
                input[i] = sc.nextInt();
            }
            
            // Arrays.sort(input); -> 가장 기본
            bubbleSort(input);
            
            System.out.print("#" + tc + " ");
            printArray(input);
		}
	}
    private static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
        	for(int j = 0; j < arr.length - 1 - i; j++){
            	if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
    	arr[j] = tmp;
    }
    
    private static void printArray(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}