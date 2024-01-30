import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		final int SIZE = 100;
		for(int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int[] num = new int[SIZE];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < SIZE; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(num);
			while(k --> 0) {
				num[0]++; num[99]--;
				Arrays.sort(num);
			}
			
			sb.append("#").append(tc).append(" ").append(num[99] - num[0]).append("\n");
		}
		System.out.println(sb);
	}
}
