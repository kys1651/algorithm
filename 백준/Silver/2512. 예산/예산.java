import java.util.Arrays;
import java.util.Scanner;

class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int upper = sc.nextInt();
        int min = 0;
        int max = arr[n-1];
        while(min <= max){
            int mid = (min + max) / 2;
            int sum = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] >= mid){
                    sum += mid;
                }else{
                    sum += arr[i];
                }
            }
            if(sum > upper){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(max);
        
    }
}