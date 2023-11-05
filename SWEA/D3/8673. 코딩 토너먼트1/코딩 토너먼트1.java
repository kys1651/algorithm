import java.util.*;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
 		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int k = (int)Math.pow(2,sc.nextInt());
            int [] a= new int[k];
            for(int i = 0; i < k; i++){
                a[i] = sc.nextInt();
            }
            int sum = 0;
            while( k > 0 ){
                for(int i = 0; i < k / 2; i++){
                    int num1 = a[i*2];
                    int num2 = a[i*2+1];
                    sum += Math.abs(num1 - num2);
                    a[i] = Math.max(num1, num2);
                }
                k /= 2;
            }
            System.out.println("#" + tc + " " + sum);
		}
	}
}