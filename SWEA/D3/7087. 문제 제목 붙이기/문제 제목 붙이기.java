import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int[] check = new int[26];
            for(int i = 0; i < n; i++){
                String str = sc.next();
                check[str.charAt(0) - 'A']++;
            }
            int idx = 0;
            for(; idx < 26; idx++){
                if(check[idx] == 0) break;
            }
            System.out.println("#" + tc + " " + idx);
		}
	}
}