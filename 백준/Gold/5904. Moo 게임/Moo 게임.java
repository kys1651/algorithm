import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] range = new long[30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		if(n <= 3) {
			System.out.println(n == 1 ? "m":"o");
			return;
		}
		int start = 0;
		range[0] = 3;
		for(int i = 1; i < 30; i++) {
			range[i] = range[i-1] * 2 + i + 3;
			if(range[i] >= n) {
				start = i;
				break;
			}
		}
		divideRange(n, start);
	}

	private static void divideRange(long n, int side) {
		if(side == 0) {
			System.out.println(n == 1?"m":"o");
			return;
		}
		// 전반 범위 안
		long value = range[side - 1];
		if (n <= value) {
			divideRange(n, side - 1);
		} 
		// 후반 범위
		else if (n - value > side + 3) {
			divideRange(n - value - (side + 3), side - 1);
		}
		// 가운데 범위
		else {
			if (n - value == 1) {
				System.out.println("m");
			} else {
				System.out.println("o");
			}
			return;
		}
	}

}
