import java.util.Scanner;

class Main{ 
    public static final int DIV = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = (factorial(n) * pow(factorial(m) * factorial(n-m) % DIV, DIV - 2)) % DIV;
        System.out.println(result);
    }
    private static int pow(int a, int p) {
        int ret = 1;
        while(p > 0){
            if(p%2!=0){
                ret *= a;
                p--;
                ret %= DIV;
            }
            a *= a;
            a %= DIV;
            p /= 2;
        }
        return ret;
    }
    private static int factorial(int n){
        if(n <= 1) return 1;
        return (n * factorial(n-1)) % DIV;
    }
}
