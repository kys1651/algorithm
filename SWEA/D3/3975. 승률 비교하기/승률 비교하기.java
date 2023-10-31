import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            double a = sc.nextDouble() / sc.nextDouble();
            double b = sc.nextDouble() / sc.nextDouble();
            System.out.println("#" + tc + " " + (a == b?"DRAW" : (a > b ? "ALICE" : "BOB")));
		}
	}
}