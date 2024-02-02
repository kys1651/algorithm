import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int idx = 1;

			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {idx++,1});

			while (true) {
				int[] p = queue.poll();
				n -= p[1];
				if (n <= 0) {
					sb.append("#").append(tc).append(" ").append(p[0]).append("\n");
					break;
				}
				queue.offer(new int[] {p[0],p[1]+1});
				queue.offer(new int[] {idx++, 1});
			}
		}
		System.out.println(sb);
	}
}
