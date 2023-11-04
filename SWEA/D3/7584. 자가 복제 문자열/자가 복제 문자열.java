import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            long k = sc.nextLong() - 1;
            long result = 0;
            while( k > 0){
                if(k % 2 == 1) k = (k-1)/ 2;
                if(k%4 ==0){
                    result = 0;
                    break;
                }
                else if(k % 2== 0){
                    result = 1;
                    break;
                }
            }
            System.out.println("#" + tc + " " + result);
        }
	}
}