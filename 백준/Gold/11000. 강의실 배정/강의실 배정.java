import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Lecture implements Comparable<Lecture>{
		int start;
		int end;
		
		public Lecture(int start,int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			if(start != o.start) {
				return start - o.start;
			}
			return end - o.end;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> ingList = new PriorityQueue<>();
		Lecture[] lectureList = new Lecture[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lectureList[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(lectureList);
		ingList.add(lectureList[0].end);
		for(int i = 1; i < N; i++) {
			if(lectureList[i].start >= ingList.peek()) {
				ingList.poll();
			}
			ingList.add(lectureList[i].end);
		}
		System.out.println(ingList.size());
	}

}
