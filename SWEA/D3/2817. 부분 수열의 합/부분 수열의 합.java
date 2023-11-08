import java.util.Scanner;

class Solution
{
    static int n,k,result;
    static boolean[] visit;
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
            visit = new boolean[n];
            for(int i = 0; i < n; i++){
                num[i] = sc.nextInt();
            }
			solution(0,0,num);
            System.out.println("#" + tc + " " + result);
		}
	}
    private static void solution(int depth, int sum, int[] num){
        if(sum >= k){
            if(sum == k) result++;
            return;
        }
        for(int i = depth; i < n; i++){
            if(visit[i]) continue;
            visit[i] = true;
            solution(i,sum + num[i], num);
            visit[i] = false;
        }
    }
    
}