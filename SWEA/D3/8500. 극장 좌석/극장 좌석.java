import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
            int n = sc.nextInt();
            int result = 0;
            int max = 0;
            for(int i = 0; i < n; i++){ 
                int tmp = sc.nextInt();
                result += tmp;
                max = Math.max(max,tmp);
            }
            System.out.println("#" + tc + " " + (result + max + n));
		}
	}
}