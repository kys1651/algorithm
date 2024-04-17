import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] lis = new int[N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (count == 0) {
				lis[count++] = tmp;
			} else {
				if (lis[count - 1] < tmp) {
					lis[count++] = tmp;
				} else if (lis[0] > tmp) {
					lis[0] = tmp;
				} else {
					lis[search(0, count - 1, tmp, lis)] = tmp;
				}
			}
		}
		System.out.println(count);
	}

	private static int search(int l, int r, int key, int[] lis) {
		while (l <= r) {
			int m = (l + r) >> 1;
			if (lis[m] > key) {
				r = m - 1;
			} else if (lis[m] < key) {
				l = m + 1;
			} else {
				return m;
			}
		}
		return l;
	}
}
