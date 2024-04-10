import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> nq = new PriorityQueue<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

		// Input
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp <= 0)
				nq.add(tmp);
			else if (tmp > 0)
				pq.add(tmp);
		} // Input End

		int answer = 0;
		while (nq.size() >= 2) {
			int a = nq.poll();
			int b = nq.poll();
			if (a * b < a + b)
				answer += a + b;
			else
				answer += a * b;
		}
		while (pq.size() >= 2) {
			int a = pq.poll();
			int b = pq.poll();
			if (a * b < a + b)
				answer += a + b;
			else
				answer += a * b;
		}
		if (!nq.isEmpty() && !pq.isEmpty()) {
			int a = nq.poll();
			int b = pq.poll();
			if (a * b < a + b)
				answer += a + b;
			else
				answer += a * b;
		}
		if (!nq.isEmpty()) {
			answer += nq.poll();
		}
		if (!pq.isEmpty()) {
			answer += pq.poll();
		}
		System.out.println(answer);
	}
}
