import java.util.Scanner;

class Main{ 
    public static final long DIV = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long k = sc.nextInt();
        
        long numer = factorial(n);
        long denom = factorial(k) * factorial(n - k) % DIV;

        System.out.println(numer * pow(denom, DIV - 2) % DIV);
    }

    private static long pow(long base, long expo) {
        long ret = 1;
        while(expo > 0){
            if(expo % 2 == 1){
                ret = (ret * base) % DIV;
                expo--;
            }
            base *= base;
            base %= DIV;
            expo /= 2;
        }
        return ret;
    }
    
    private static long factorial(long n){
        long fac = 1L;
        for(long i = 1; i <= n; i++){
            fac *= i;
            fac %= DIV;
        }
        return fac;
    }
}
