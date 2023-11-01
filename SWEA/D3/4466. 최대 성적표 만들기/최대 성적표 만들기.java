import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int num[] = new int[n];
            for(int i = 0; i < n; i++){
                num[i] = sc.nextInt();
            }
            Arrays.sort(num);
            int sum = 0;
            for(int i = 0; i < k ;i++){
                sum += num[n - i - 1];
            }
            System.out.println("#" + tc + " " + sum);
		}
	}
}