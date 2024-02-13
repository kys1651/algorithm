import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> queue = new PriorityQueue<>((o1,o2)->Long.compare(o1, o2));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			queue.add(Long.parseLong(st.nextToken()));
		}
		
		while(m --> 0) {
			long next = queue.poll() + queue.poll();
			queue.add(next);
			queue.add(next);
		}
		
		long answer = 0;
		while(!queue.isEmpty()) {
			answer += queue.poll();
		}
		
		System.out.println(answer);
	}

}
