import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<>(
				(o1, o2) -> Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2));
		
		int n = Integer.parseInt(br.readLine());
		
		while (n-- > 0) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) {
				if (queue.isEmpty()) {
					sb.append(0);
				} else {
					sb.append(queue.poll());
				}
				sb.append('\n');
			} else {
				queue.add(tmp);
			}
		}
		System.out.println(sb);
	}

}
