import java.util.Scanner;
class Solution
{
    static int max = -1;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int[] num = new int[n];
            max = -1;
            for(int i = 0; i < n; i++){
                num[i] = sc.nextInt();
            }
            for(int i = 0; i < n - 1; i++){
                for(int j = i + 1; j < n; j++){
                    int testValue = num[i] * num[j];
                    if(testValue > max && isCheck(testValue)){
                        max = testValue;
                    }
                }
            }
            System.out.println("#" + tc + " "+ max);
		}
	}
    private static boolean isCheck(int num){
        int right = num % 10;
        int tmp = num;
        while(tmp != 0){
            if(tmp % 10 > right){
                return false;
            }
            right = tmp % 10;
            tmp /= 10;
        }
        return true;
    }
}
