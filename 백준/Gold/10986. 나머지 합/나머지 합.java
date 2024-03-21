import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] div = new long[M]; // 나머지를 저장하는 배열

		int prefixSum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			// 누적값을 구해서 M으로 나눈 값을 저장한다.
			prefixSum = (prefixSum + Integer.parseInt(st.nextToken())) % M;
			div[prefixSum]++; // 나머지 값 카운팅
		}

		// 나머지 값이 같은 인덱스 중 2개를 뽑는 모든 경우의 수를 구해준다.
		long result = div[0];
		for (int i = 0; i < M; i++) {
			result += div[i] * (div[i] - 1) >> 1;
		}

		System.out.println(result);
	}
}
