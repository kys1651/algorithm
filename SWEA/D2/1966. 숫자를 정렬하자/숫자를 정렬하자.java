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
            // bubbleSort(input); -> bubble sort
            // selectionSort(input); -> select sort
            insertionSort(input);
            
            System.out.print("#" + tc + " ");
            printArray(input);
		}
	}
    
    private static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int tmp = arr[i];
            int j = i - 1;
            while(j >= 0 && tmp < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = tmp;
        }
    }
    
    private static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            // 최소값을 가지는 idx
            int minIdx = i;
            // i + 1부터 끝까지 비교해서 최소값인 인덱스를 찾음
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            swap(arr,i,minIdx);
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