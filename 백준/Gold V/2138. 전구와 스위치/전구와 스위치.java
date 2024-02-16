import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] a = new boolean[N];
		boolean[] b = new boolean[N];
		boolean[] target = new boolean[N];

		String input = br.readLine();
		for (int i = 0; i < N; i++) {
			a[i] = input.charAt(i) == '0' ? false : true;
			b[i] = a[i];
		}

		input = br.readLine();
		for (int i = 0; i < N; i++) {
			target[i] = input.charAt(i) == '0' ? false : true;
		}

		int result = -1;
		if (onOff(a, target)) {
			result = count;
		}

		count = 1;
		lightOnOff(b,0);
		
		if(onOff(b,target)) {
			result = result == -1? count : Math.min(result, count);
		}
		
		System.out.println(result);
	}

	private static boolean onOff(boolean[] from, boolean[] to) {
		for (int i = 1; i < from.length; i++) {
			if (from[i - 1] != to[i - 1]) {
				count++;
				lightOnOff(from, i);
			}
		}

		if(from[from.length-1]==to[to.length-1]) {
			return true;
		}else {
			return false;
		}
	}

	private static void lightOnOff(boolean[] light, int n) {
		if (n - 1 >= 0) {
			light[n - 1] = !light[n - 1];
		}

		light[n] = !light[n];

		if (n + 1 < light.length) {
			light[n + 1] = !light[n + 1];
		}
	}
}
