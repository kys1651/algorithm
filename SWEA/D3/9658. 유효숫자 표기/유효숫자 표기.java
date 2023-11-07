import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            String number = sc.next();
            int len = number.length() - 1;
            int c = (int)Math.round((number.charAt(2) - '0') * 0.1);
            int b = number.charAt(1) - '0' + c;
            int a = number.charAt(0) - '0';
            if(b == 10) {
                a++;
                b = 0;
            }
            if(a == 10) {
                a = 1;
                len++;
            }
			System.out.println("#" + tc + " " + a + "."+ b + "*10^" + len);
		}
	}
}