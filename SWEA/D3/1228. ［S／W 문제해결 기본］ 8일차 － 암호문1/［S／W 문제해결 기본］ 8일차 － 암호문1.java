import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < k; i++) {
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for(int j = 0; j < count; j++) {
					list.add(idx+j,Integer.parseInt(st.nextToken()));
				}
			}
			
			sb.append('#').append(tc).append(' ');
			for(int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
