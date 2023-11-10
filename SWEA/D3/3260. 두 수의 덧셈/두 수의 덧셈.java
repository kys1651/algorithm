import java.util.Scanner;
import java.math.BigInteger;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            BigInteger b1 = new BigInteger(sc.next());
            BigInteger b2 = new BigInteger(sc.next());
            System.out.println("#" + tc + " " + b1.add(b2));
		}
	}
}