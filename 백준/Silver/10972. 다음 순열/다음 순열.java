import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		if (np(input)) {
			for(int v : input) {
				sb.append(v).append(' ');
			}
		} else {
			sb.append(-1);
		}
		System.out.println(sb);
	}

	private static boolean np(int[] p) {
		int i = p.length - 1;
		while (i > 0 && p[i - 1] >= p[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}

		int j = p.length - 1;
		while (p[i - 1] >= p[j]) {
			j--;
		}
		swap(p, i - 1, j);

		j = p.length - 1;
		while (i < j) {
			swap(p, j, i);
			i++;
			j--;
		}
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
