import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            long n = sc.nextInt();
            System.out.println("#" + tc + " " + (2 * (n - 1) * (n - 1) + 1) + " " + (n * n * 2 - 1));
		}
	}
}