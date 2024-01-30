import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		final int SIZE = 100;
		for(int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> minQueue = new PriorityQueue<>((o1,o2)->o1-o2);
			PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1,o2)->o2-o1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < SIZE; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				minQueue.add(tmp);
				maxQueue.add(tmp);
			}
			while(k --> 0) {
				minQueue.add(minQueue.poll() + 1);
				maxQueue.add(maxQueue.poll() - 1);
			}
			
			sb.append("#").append(tc).append(" ").append(maxQueue.poll() - minQueue.poll()).append("\n");
		}
		System.out.println(sb);
	}
}
