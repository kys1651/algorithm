import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());

			int result = 1;
			for (int i = 1; i <= n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				
				char value = st.nextToken().charAt(0);
				boolean isDigit = Character.isDigit(value);
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
