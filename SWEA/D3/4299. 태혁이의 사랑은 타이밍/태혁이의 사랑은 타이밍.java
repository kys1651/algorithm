import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        int check = sumTimes(11,11,11);
		for(int tc = 1; tc <= T; tc++) {
            int d = sc.nextInt();
            int h = sc.nextInt();
            int m = sc.nextInt();
            int totalM = sumTimes(d,h,m);
            System.out.println("#" + tc + " " + (totalM - check < 0 ? "-1" : totalM - check));
		}
	}
    private static int sumTimes(int day, int hour, int min){
        return day * 24 * 60 + hour * 60 + min;
    }
}