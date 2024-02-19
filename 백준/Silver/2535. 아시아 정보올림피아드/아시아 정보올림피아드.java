import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Student implements Comparable<Student> {
		int a;
		int b;
		int c;

		public Student(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Student o) {
			return o.c - this.c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Student> queue = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			queue.add(new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		int count = 3;
		while (count != 0) {
			Student tmp = queue.poll();
			if (map.getOrDefault(tmp.a, 0) == 2) {
				continue;
			}

			sb.append(tmp.a + " " + tmp.b);
			sb.append('\n');
			count--;
			map.put(tmp.a, map.getOrDefault(tmp.a, 0) + 1);
		}
		System.out.println(sb);
	}
}
