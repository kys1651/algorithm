import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		int i = 1;
		while ((1 << i) < K) {
			i++;
		}

		sb.append(1 << i).append(' ');
		int mod = (1 << i) - K;
		int count = 0;
		while (mod != 0) {
			i--;
			if (mod >= (1 << i)) {
				mod -= (1 << i);
			}
			count++;
		}
		sb.append(count);
		System.out.println(sb);
	}
}
