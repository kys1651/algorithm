import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        int[] mons = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        int[] days = {3,4,5,6,0,1,2};
        for(int tc = 1; tc <= T; tc++) {
            int mon = sc.nextInt();
            int sum = sc.nextInt();
            for(int i = 0; i < mon; i++){
                sum += mons[i];
            }
            System.out.println("#" + tc + " " + (days[sum % 7 ]));
		}
	}
}