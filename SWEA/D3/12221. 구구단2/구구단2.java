import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int a = sc.nextInt(); int b = sc.nextInt();
           System.out.println("#" + tc + " " + ((a < 10) && (b < 10) ? a*b: -1));
		}
	}
}