import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int[] visit = new int[101];
	static int[] move = new int[101];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		bfs();
	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 1; i <= 6; i++) {
				// 다음 위치
				int nX = cur + i;
				
				// 100을 넘거나 (방문했을때) 더 가성비 있다면 넘어감
				if(nX > 100 || visit[nX] != 0 && visit[nX] <= visit[cur] + 1) {
					continue;
				}
				
				visit[nX] = visit[cur] + 1;
				if(move[nX] != 0) {
					int next = move[nX];
					if(visit[next] == 0 || visit[next] > visit[nX] + 1) {
						visit[move[nX]] = visit[nX];
						queue.add(move[nX]);
					}
				}else {
					queue.add(nX);
				}
			}
		}
		
		System.out.println(visit[100]);
		
	}
}
