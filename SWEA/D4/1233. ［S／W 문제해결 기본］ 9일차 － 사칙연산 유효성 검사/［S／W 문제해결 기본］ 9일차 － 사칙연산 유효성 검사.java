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

			int result = 1;
			StringTokenizer st;
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
				boolean isDigit = Character.isDigit(tree[i]);
				if(st.hasMoreTokens()) {
					if(isDigit) {
						result = 0;
					}
				}else {
					if(!isDigit) {
						result = 0;
					}
				}
			}

			
			sb.append('#').append(tc).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
}
