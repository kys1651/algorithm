import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static class Person {
		int num;
		int cnt;

		public Person(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int idx = 1;

			Queue<Person> queue = new LinkedList<>();
			queue.add(new Person(idx++, 1));

			while (true) {
				Person p = queue.poll();
				n -= p.cnt;
				if (n <= 0) {
					sb.append("#").append(tc).append(" ").append(p.num).append("\n");
					break;
				}
				p.cnt++;
				queue.offer(p);
				queue.add(new Person(idx++, 1));
			}
		}
		System.out.println(sb);
	}
}
