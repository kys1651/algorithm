import java.util.Scanner;

class Solution
{
    static int n,k,result;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			n = sc.nextInt();
            k = sc.nextInt();
            result = 0;
            int[] num = new int[n];
            for(int i = 0; i < n; i++){
                num[i] = sc.nextInt();
            }
			solution(0,0,num);
            System.out.println("#" + tc + " " + result);
		}
	}
    private static void solution(int depth, int sum, int[] num){
        if(sum > k){
            return;
        }
        if(depth == n){
            if(sum == k){
                result++;
            }
            return;
        }
        solution(depth+1,sum + num[depth],num);
        solution(depth+1,sum,num);
    }
    
}