import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 51;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// Init
		int[][] graph = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				graph[i][j] = INF;
			}
			graph[i][i] = 0;
		} // Init End

		// Input
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1)
				break;
			graph[a][b] = graph[b][a] = 1;
		} // Input End

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (k == i || graph[i][k] == 0)
					continue;
				for (int j = 1; j <= N; j++) {
					if (graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		int minVal = INF;
		for(int i = 1; i <= N; i++) {
			int tmp = 0;
			for(int j = 1; j <= N; j++) {
				if(tmp < graph[i][j]) tmp = graph[i][j];
			}
			if(minVal > tmp) {
				minVal = tmp;
				list.clear();
				list.add(i);
			}else if(minVal == tmp) {
				list.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(minVal).append(' ').append(list.size()).append('\n');
		for(int i : list) sb.append(i).append(' ');
		
		System.out.println(sb);
	}

}
