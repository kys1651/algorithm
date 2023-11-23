import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < i; j++) {
				sb.append(" ");
			}

			for (int j = 0; j < (2 * n - 1) - (2 * i); j++) {
				sb.append("*");
			}

			sb.append("\n");
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = 1; j < (n - 1) - i; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < 3 + 2 * i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
