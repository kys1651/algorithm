import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int day = sc.nextInt();
            int arr[] = new int[7];
            int result = Integer.MAX_VALUE;
            for(int i = 0 ; i < 7; i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < 7; i++){
                if(arr[i] == 0){
                    continue;
                }
                int count = 0;
                int start = i;
                int tmp = day;
                while(tmp != 0){
                    tmp -= arr[start%7];
                    count++; start++;
                }
                result = Math.min(result, count);
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}