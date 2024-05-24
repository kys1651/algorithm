import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][M + 1];

		boolean[][] obstacle = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				obstacle[i][j] = st.nextToken().equals("0");
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!obstacle[i][j]) {
					continue;
				}
				map[i][j] = Math.min(Math.min(map[i - 1][j - 1], map[i - 1][j]), map[i][j - 1]) + 1;
				answer = Math.max(answer, map[i][j]);
			}
		}
		System.out.println(answer);
	}
}