import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static final int SIZE = 8;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			br.readLine();
			Queue<Integer> queue = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < SIZE; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int minus = 1;
			while(true) {
				int top = queue.poll();
				top -= minus++;
				if(top <= 0) {
					queue.add(0);
					break;
				}
				if(minus == 6) {
					minus = 1;
				}
				queue.add(top);
			}
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i <SIZE; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
