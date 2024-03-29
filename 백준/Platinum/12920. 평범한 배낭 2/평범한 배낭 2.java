import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[M + 1];
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 1; k > 0; j = j << 1) {
				int tmp = Math.min(j, k);
				int weight = tmp * v;
				int cost = tmp * c;
				for(int l = M; l >= weight; l--) {
					if(dp[l] < dp[l-weight] + cost) {
						dp[l] = dp[l-weight] + cost;
						if(dp[l] > answer) answer = dp[l];
					}
				}
				k -= tmp;
			}
		}

		System.out.println(answer);
	}
}
