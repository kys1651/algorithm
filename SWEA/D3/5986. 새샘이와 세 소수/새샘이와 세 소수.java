import java.util.Scanner;
class Solution {
    static boolean[] prime;
    static int result,n;
    static int[] arr = new int[3];
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        prime = new boolean[1001];
        prime[0] = prime[1] = true;
        for(int i = 2; i <= Math.sqrt(prime.length); i++){
            if(prime[i]) continue;
            for(int j = i * 2; j < prime.length; j += i){
                prime[j] = true;
            }
        }
		for(int tc = 1; tc <= T; tc++)
		{
            n = sc.nextInt();
            result = 0;
            bruteforce(n);
            System.out.println("#" + tc + " " + result);
        }
	}
    private static void bruteforce(int n){
        for(int i = 2; i < prime.length; i++){
            if(prime[i]) continue;
            for(int j = i; j < prime.length; j++){
                if(prime[j] || i + j > n) continue;
                for(int k = j; k < prime.length; k++){
                    if(prime[k] || i + j + k > n) continue;
                    if(i + j + k == n) result++;
                }
            }
        }
    }
}