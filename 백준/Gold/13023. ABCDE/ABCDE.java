import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static ArrayList<Integer>[] graph;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		graph = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		if(n < 5) {
			System.out.println(0);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			visit[i] = true;
			searchABCDE(i,1);
			visit[i] = false;
		}
		System.out.println(0);
	}
	
	private static void searchABCDE(int pos, int count) {
		if(count == 5) {
			System.out.println("1");
			System.exit(0);
		}
		
		for(int next : graph[pos]) {
			if(visit[next]) continue;
			visit[next] = true;
			searchABCDE(next,count+1);
			visit[next] = false;
		}
	}
}
