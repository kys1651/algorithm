import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n][n];
			int sum = 0;
			for(int i = 0 ; i  < n; i++) {
				String input = br.readLine();
				for(int j = 0; j < n; j++) {
					map[i][j] = input.charAt(j) - '0';
					sum += map[i][j];
				}
			}
			
			int len = n/2;
			int last = n-1;
			for(int i = 0; i < len;i++) {
				for(int j = 0; j < len - i; j++) {
					sum -= (map[i][j] + map[last-i][j] + map[i][last-j] + map[last-i][last-j]);
				}
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
