import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static class Lecture implements Comparable<Lecture> {
		int start;
		int end;

		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			if (end == o.end) {
				return start - o.start;
			}
			return end - o.end;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Lecture[] lectures = new Lecture[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lectures[i] = new Lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(lectures);
		
		int time = lectures[0].end;
		int answer = 1;
		for(int i = 1; i < N; i++) {
			if(time <= lectures[i].start) {
				time = lectures[i].end;
				answer++;
			}
		}
		System.out.println(answer);
		
	}

}
