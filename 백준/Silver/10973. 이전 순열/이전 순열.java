import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int i = n - 1;
		while (i - 1 >= 0 && arr[i - 1] <= arr[i]) {
			i--;
		}

		if (i == 0) {
			System.out.println(-1);
			return;
		}

		int j = n-1;
		for(; arr[i-1] < arr[j]; j--) {}
		swap(arr, i - 1, j);

		for (j = n - 1; i < j; i++, j--) {
			swap(arr, i, j);
		}

		for (int a : arr) {
			sb.append(a).append(' ');
		}
		System.out.println(sb);
	}

	private static void swap(int[] p, int i, int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
}
