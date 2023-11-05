import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            double p = sc.nextDouble();
            double q = sc.nextDouble();
            System.out.println("#" + tc + " " + (1-p < p * (1 - q) ? "YES" : "NO"));
		}
	}
}