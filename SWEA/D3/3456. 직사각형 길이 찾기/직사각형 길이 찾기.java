import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = (a == b ? c : (b == c ? a : b));
            System.out.println("#" + tc + " " + d);
		}
	}
}