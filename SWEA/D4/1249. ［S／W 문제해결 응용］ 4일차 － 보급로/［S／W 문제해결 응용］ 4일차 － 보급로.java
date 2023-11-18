import java.util.*;
class Solution {
	static int[][] map;
	static int[][] value;
	static int n;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			value = new int[n][n];
			for (int i = 0; i < n; i++) {
				String line = sc.next();
				for (int j = 0; j < n; j++) {
					map[i][j] = line.charAt(j) - '0';
					value[i][j] = -1;
				}
			}
			bfs();
			System.out.println("#" + tc + " " + value[n-1][n-1]);
		}
	}

	private static void bfs() {
		int[] dirX = {-1,1,0,0};
		int[] dirY = {0,0,-1,1};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0,0});
		value[0][0] = 0;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int curX = pos[0];
			int curY = pos[1];
			for(int i = 0; i < 4; i++) {
				int nX= curX+ dirX[i];
				int nY = curY + dirY[i];
				if(nX < 0 || nX >= n || nY < 0 || nY >= n) {
					continue;
				}
				if(value[nX][nY] == -1 || (value[nX][nY] > value[curX][curY] + map[nX][nY])) {
					value[nX][nY] = value[curX][curY] + map[nX][nY];
					queue.offer(new int[] {nX,nY});
				}
			}
		}
	}
}