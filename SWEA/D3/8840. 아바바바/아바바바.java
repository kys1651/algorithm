import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
            long L = sc.nextInt();
            System.out.println("#" + tc + " " + (L - 1) * (L / 2) / 2);
		}
	}
}