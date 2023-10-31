import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            long n = sc.nextLong();
            long a = (1 + n) * n / 2;
            long b = (1 + 2 * n - 1) * n / 2;
            long c = (2 + 2 * n) * n /2;
            System.out.println("#" + tc + " " + a  + " " + b + " " + c);
		}
	}
}