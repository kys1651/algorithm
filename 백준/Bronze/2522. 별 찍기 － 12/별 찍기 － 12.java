import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int len = 2 * n - 1;
		for (int i = 1, j = 1; i <= len; i++) {
			System.out.print(" ".repeat(n - j));
			System.out.print("*".repeat(j));
			System.out.println();
			if (i < n) {
				j++;
			} else {
				j--;
			}
		}
	}
}
