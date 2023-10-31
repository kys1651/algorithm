import java.util.Scanner;
import java.math.BigInteger;
class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
           	long n = sc.nextLong();
            long result = -1;
            long i = 1;
            while( i * i * i <= n){
                if(i * i * i == n){
                    result = i;
                    break;
                }
                i++;
            }
            System.out.println("#" + tc + " " + result);
        }
	}
}