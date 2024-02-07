import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int a1 = Math.abs(o1);
			int a2 = Math.abs(o2);
			if (a1 == a2) {
				return Integer.compare(o1, o2);
			}
			return a1 - a2;
		});

		while (n-- > 0) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) {
				if (queue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(queue.poll());
				}
			} else {
				queue.add(tmp);
			}
		}
	}

}
