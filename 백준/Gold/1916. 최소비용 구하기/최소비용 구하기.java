import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<int[]>[] list;
	static int[] values;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		int k =Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		values = new int[n+1];
		Arrays.fill(values, Integer.MAX_VALUE);
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to,w});
		}
		
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		System.out.println(values[end]);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[1] - o2[1]);
		queue.offer(new int[] {start,0});
		
		boolean[] visit = new boolean[n+1];
		// 시작점이니까 0 넣어줌
		values[start] = 0;
		
		while(!queue.isEmpty()) {
			int curs[] = queue.poll();
			int cur = curs[0];
			if(visit[cur]) continue;
			visit[cur] = true;
			
			for(int[] next : list[cur]) {
				int end = next[0];
				int endW = next[1];
				if(values[end] > values[cur] + endW) {
					values[end] = values[cur] + endW;
					queue.offer(new int[] {end,values[end]});
				}
			}
		}
		
	}
}
