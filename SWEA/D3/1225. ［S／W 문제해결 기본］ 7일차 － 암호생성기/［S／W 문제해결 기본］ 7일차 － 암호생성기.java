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
			
			while(cycle(queue)) {}
			
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i <SIZE; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static boolean cycle(Queue<Integer> q) {
		for(int i = 1; i <= 5; i++) {
			int n = q.poll();
			if(n - i <= 0) {
				q.offer(0);
				return false;
			}
			q.add(n - i);
		}
		return true;
	}
}
