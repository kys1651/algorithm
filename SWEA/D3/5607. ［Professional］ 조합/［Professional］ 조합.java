import java.util.Scanner;
class Solution{
    static final long div = 1234567891L;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
            long n = sc.nextInt();
            long r = sc.nextInt();
            
            long numer = factorial(n);
            long denom = factorial(r) * factorial(n-r) % div;
            long result = numer * pow(denom, div - 2) % div;
            System.out.println("#" + tc + " " + result);
		}
	}
    private static long pow(long base, long expo){
        long ret = 1L;
        while(expo > 0){
            if(expo % 2 != 0){
                ret = (ret * base) % div;
            }
            base = (base * base) % div;
            expo /= 2;
        }
        return ret;
    }
    private static long factorial(long n){
        long fac = 1L;
        for(long i = 1; i <= n; i++){
            fac = (fac * i) % div;
        }
        return fac;
    }
}