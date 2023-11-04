import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int t = 0;
            for(; t < k; t++){
                if( 2 * t == n - (k - t)){
                    break;
                }
            }
			System.out.println("#" + tc + " " + (k - t) + " " + t);
		}
	}
}