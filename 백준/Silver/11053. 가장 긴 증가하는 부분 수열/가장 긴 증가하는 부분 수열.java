import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] value = new int[N];
		int[] dp = new int[N];
		int answer = 1;
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(value[i] > value[j] && dp[j] + 1 > dp[i]){
					dp[i] = dp[j] + 1;
					if(answer < dp[i]) {
						answer = dp[i];
					}
				}
			}
		}
		System.out.println(answer);
	}
}
