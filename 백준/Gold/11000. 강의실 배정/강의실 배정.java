import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		PriorityQueue<Lecture> lectureList = new PriorityQueue<>();
		PriorityQueue<Lecture> ingList = new PriorityQueue<>((o1,o2)->o1.end - o2.end);
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lectureList.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int answer = 1;
		ingList.add(lectureList.poll());
		while(!lectureList.isEmpty()) {
			if(ingList.peek().end <= lectureList.peek().start) {
				ingList.poll();
			}
			ingList.add(lectureList.poll());
			if(answer < ingList.size()) answer = ingList.size();
		}
		System.out.println(answer);
	}

}
