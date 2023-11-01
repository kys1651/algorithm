import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        boolean[] prime = new boolean[1000001];
        prime[0] = prime[1] = true;
        for(int i = 2; i <= Math.sqrt(prime.length); i++){
            if(prime[i]) continue;
            for(int j = 2 *  i; j < prime.length; j += i ){
                prime[j] = true;
            }
        }
		for(int tc = 1; tc <= T; tc++) { 
            String d = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = 0;
            while(a <= b){
                if(!prime[a] && String.valueOf(a).contains(d)) result++;
                a++;
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}