import java.util.Scanner;
import java.math.BigInteger;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            BigInteger bi = new BigInteger(sc.next());
            BigInteger two = new BigInteger("2");
            String result = "Odd";
            if(bi.remainder(two).intValue() == 0){result = "Even";}
            System.out.println("#" + tc + " " + result);
		}
	}
}