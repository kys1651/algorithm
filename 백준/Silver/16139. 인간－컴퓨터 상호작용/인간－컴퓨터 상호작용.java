import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		// Input
		int N = Integer.parseInt(br.readLine());
		char[] K = new char[N];
		;
		int[] S = new int[N];
		int[] E = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K[i] = st.nextToken().charAt(0);
			S[i] = Integer.parseInt(st.nextToken());
			E[i] = Integer.parseInt(st.nextToken());
		} // Input End

		int[][] count = new int[input.length() + 1][26];
		for (int i = 1; i <= input.length(); i++) {
			for (int j = 0; j < 26; j++) {
				count[i][j] = count[i - 1][j];
			}
			char ch = input.charAt(i - 1);
			count[i][ch - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int keyword = K[i];
			int start = S[i] == 0 ? 0 : count[S[i]][keyword - 'a'];
			int end = count[E[i] + 1][keyword - 'a'];
			sb.append(end - start).append('\n');
		}
		System.out.println(sb);
	}
}
