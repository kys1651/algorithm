import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
            int n = sc.nextInt();
            int x = sc.nextInt();
            int range = 2 * x + 1;
            int result = n / range + (n % range != 0 ? 1 : 0);
            System.out.printf("#%d %d\n",tc,result);
		}
	}
}