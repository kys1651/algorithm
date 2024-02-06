import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			char[] tree = new char[n + 1];

			StringTokenizer st;
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}

			int result = 1;
			for (int i = 1; i <= n; i++) {
				if (Character.isDigit(tree[i])) {
					if (i * 2 <= n && Character.isDigit(tree[i * 2])) {
						result = 0;
						break;
					}
					if (i * 2 + 1 <= n && Character.isDigit(tree[i * 2 + 1])) {
						result = 0;
						break;
					}
				}
			}
			sb.append('#').append(tc).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
}
