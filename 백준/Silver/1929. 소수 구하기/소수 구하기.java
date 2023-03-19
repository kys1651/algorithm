import java.util.Scanner;

public class Main {
    public static boolean[] check;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();

        check = new boolean[N + 1];//전부 false로 초기화 되어있음
        get_prime();

        for(int i = M; i <= N; i++) {
            // false = 소수
            if(!check[i]) System.out.println(i);
        }
    }

    public static void get_prime() {
        check[0] = check[1] = true;

        for(int i = 2; i <= Math.sqrt(check.length); i++) {
            if(check[i]) continue;
            for(int j = i * i; j < check.length; j += i) {
                check[j] = true;
            }
        }
    }
}