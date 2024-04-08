import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		int[][] dist = new int[N][N];
		
		// Input
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = graph[i][j];
			}
		} // Input End

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(k == i) continue;
				for (int j = 0; j < N; j++) {
					if(i == j || j == k) continue;
					// 플로이드 와샬을 진행한 상황에 한번 더 생긴다면 모순이다
					if(graph[i][j] > graph[i][k] + graph[k][j]) {
						System.out.println(-1);
						return;
					}
					// 같다면 최단 경로인 상황 끊어준다.
					if(graph[i][j] == graph[i][k] + graph[k][j]) {
						dist[i][j] = 0;
					}
				}
			}
		}
		
		// Output
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sum += dist[i][j];
			}
		}// Output End
		System.out.println(sum / 2);
	}
}
