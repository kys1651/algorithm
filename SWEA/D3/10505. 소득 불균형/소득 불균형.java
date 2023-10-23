import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[] arr;
        int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            arr = new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            double avg = sum / (double)n;
            Arrays.sort(arr);
            
            int count = 0;
            for(;count < n; count++){
                if(arr[count] > avg){
                    break;
                }
            }
            System.out.println("#" + tc + " "+ count);
		}
	}
}