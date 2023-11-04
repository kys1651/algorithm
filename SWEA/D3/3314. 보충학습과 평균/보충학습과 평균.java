import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int sum = 0;
            for(int i = 0; i < 5;i++) {
                int value = sc.nextInt();
                sum += value < 40? 40 : value;
            }
            System.out.println("#" + tc + " " + sum / 5);
		}
	}
}