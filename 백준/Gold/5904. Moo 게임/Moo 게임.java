import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		if(n <= 3) {
			System.out.println(n == 1 ? "m":"o");
			return;
		}
		list.add((long) 3);
		int i = 1;
		for (; list.get(i - 1) <= n; i++) {
			list.add(list.get(i - 1) * 2 + i + 3);
		}
		divideRange(n, i - 1);
	}

	private static void divideRange(long n, int side) {
		if(side == 0) {
			System.out.println(n == 1?"m":"o");
			return;
		}
		// 전반 범위 안
		long range = list.get(side - 1);
		if (n <= range) {
			divideRange(n, side - 1);
		} else if (n - range > side + 3) {
			divideRange(n - range - (side + 3), side - 1);
		}else {
			if (n - range == 1) {
				System.out.println("m");
			} else {
				System.out.println("o");
			}
			System.exit(0);
		}
	}

}
