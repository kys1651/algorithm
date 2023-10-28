import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int rangeStart = Math.max(a,c);
            int rangeClose = Math.min(b,d);
            System.out.println("#" + tc + " " + (rangeStart > rangeClose ? 0 : rangeClose - rangeStart));
		}
	}
}