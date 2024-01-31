import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	// 우,하,좌,상으로 이동
	static int[] dirX = { 0, 1, 0, -1 };
	static int[] dirY = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			int idx = 1;
			int x = 0, y = 0,d = 0;
			while(idx <= N * N) {
				board[x][y] = idx++;
				int nX = x + dirX[d];
				int nY = y + dirY[d];
				if(nX < 0 || nY < 0 || nX >= N || nY >= N || board[nX][nY] != 0) {
					d = (d + 1) % 4;
					x += dirX[d];
					y += dirY[d];
					continue;
				}
				x = nX;
				y = nY;
			}
			
			sb.append("#").append(tc).append("\n");
			for(int[] nums : board) {
				for(int num : nums) {
					sb.append(num).append(" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
