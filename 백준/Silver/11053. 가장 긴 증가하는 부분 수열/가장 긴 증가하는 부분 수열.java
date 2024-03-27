import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] seq = new int[N];
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		} // Input End

		int[] lis = new int[N];
		lis[0] = seq[0];
		int idx = 1;
		for (int i = 1; i < N; i++) {
			if (lis[idx - 1] < seq[i]) {
				lis[idx++] = seq[i];
			} else if (lis[0] > seq[i]) {
				lis[0] = seq[i];
			} else {
				int left = 0, right = idx - 1;
				int key = -1;
				while (left <= right) {
					int mid = (left + right) >> 1;

					if (lis[mid] < seq[i]) {
						left = mid + 1;
					} else if (lis[mid] > seq[i]) {
						right = mid - 1;
					} else {
						key = mid;
						break;
					}
				}
				lis[key == -1 ? left : key] = seq[i];
			}
		}

		System.out.println(idx);
	}
}
