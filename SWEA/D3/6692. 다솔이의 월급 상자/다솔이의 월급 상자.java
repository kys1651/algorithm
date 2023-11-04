import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            double result = 0;
            for(int i = 0; i < n; i++){
                result += sc.nextDouble() * sc.nextDouble();
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}