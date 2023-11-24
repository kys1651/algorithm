import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n - 1; i++) {
            System.out.print(" ".repeat(n - i));
            System.out.print("*");
            System.out.print(" ".repeat(2 * i - 3 < 0 ? 0 : 2 * i - 3));
            System.out.println(i != 1 ? "*" : "");
        }
        System.out.print("*".repeat(2 * n - 1));
        System.out.println();
    }
}
