import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] lecture = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			if (p < l) {
				lecture[i] = 1;
				br.readLine();
				continue;
			}

			st = new StringTokenizer(br.readLine());
			int[] arr = new int[p];
			for (int j = 0; j < p; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			lecture[i] = arr[p - l];
		}

		Arrays.sort(lecture);

		int answer = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += lecture[i];
			if (sum > M) {
				break;
			}
			answer++;
		}

		System.out.println(answer);
	}
}
