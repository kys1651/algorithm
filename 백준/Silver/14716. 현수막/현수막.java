import java.io.*;
import java.util.*;

class Main{
	static int[][] map;
	static boolean[][] visit;
	static int m,n;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int result = 0;
		visit = new boolean[m][n];
		map = new int[m][n];
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0 ; j < n; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					result++;
					dfs(i,j);
				}
			}
		}
		System.out.println(result);
	}

	static int[] dirX = {-1,1,0,0,-1,1,-1,1};
	static int[] dirY = {0,0,-1,1,-1,-1,1,1};
	private static void dfs(int x, int y) {
		for(int i = 0; i < dirX.length; i++) {
			int nX = x + dirX[i];
			int nY = y + dirY[i];
			if(isValid(nX,nY) && map[nX][nY] == 1 && !visit[nX][nY]) {
				visit[nX][nY] = true;
				dfs(nX,nY);
			}
		}
	}
	
	private static boolean isValid(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}
}
