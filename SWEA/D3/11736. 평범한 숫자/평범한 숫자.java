import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int count = 0;
            int[] num = new int[n];
            for(int i = 0; i < n; i++){
                num[i] = sc.nextInt();
            }
            for(int i = 1; i < n -1 ; i++){
                int tmp[] = new int[] {num[i-1],num[i],num[i+1]};
                Arrays.sort(tmp);
                if(tmp[1] == num[i]) count++;
            }
            System.out.println("#" + tc + " " + count);
		}
	}
}