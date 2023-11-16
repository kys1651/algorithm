import java.util.Scanner;
class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        System.out.println(pow(a, b, c));
	}

    private static long pow(long base, long exponent, long mod){
        if(exponent == 1){
            return base % mod;
        }

        long tmp = pow(base, exponent / 2, mod);
        
        if(exponent % 2 == 1){
            return (tmp * tmp % mod) * base % mod;
        }
        return tmp * tmp % mod;
    }
}