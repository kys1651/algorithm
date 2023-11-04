import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 10; i++){
                int tmp = sum(sc.nextInt());
                max = Math.max(tmp,max);
                min = Math.min(tmp,min);
            }
            System.out.println("#" + tc + " " + max + " " +min);
		}
	}
    private static int sum(int n){
        int sum = 0;
        while(n != 0){
            sum += n %10;
            n /= 10;
        }
        return sum;
    }
}