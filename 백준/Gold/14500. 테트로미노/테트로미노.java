import java.io.*;
import java.util.*;

class Main{
	static int[][] map;
	static int n,m;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for(int i = 0 ; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0 ; j < m; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int answer = tetris();
        System.out.println(answer);
    }
	private static int tetris() {
		int[][] dirX = {
				// 첫번째 도형
				{1,2,3},{0,0,0},
				// 두번째 도형
				{0,1,1},
				// 세번째 도형
				{1,2,2},{1,2,2},{0,1,2},{0,1,2},{1,1,1},{0,0,-1},{-1,-1,-1},{-1,-1,-1},
				// 네번째 도형
				{1,1,2},{-1,-1,-2},{0,-1,-1},{0,1,1},
				// 다섯번째 도형
				{0,0,1},{-1,0,1},{-1,0,0},{1,1,2}};
		int[][] dirY = {
				// 첫번째 도형
				{0,0,0},{1,2,3},
				// 두번째 도형
				{1,0,1},
				// 세번째 도형
				{0,0,1},{0,0,-1},{1,0,0},{1,1,1},{0,1,2},{1,2,2},{0,1,2},{0,-1,-2},
				// 네번째 도형
				{0,1,1},{0,1,1},{1,1,2},{1,1,2},
				// 다섯번째 도형
				{1,2,1},{1,1,1},{1,1,2},{0,1,0}
		};
		int result = 0;
		int sum = 0;
		boolean flag = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < dirX.length; k++) {
					sum = map[i][j];
					flag = true;
					for(int d = 0; d < dirX[k].length; d++) {
						int nX = i + dirX[k][d];
						int nY = j + dirY[k][d];
						if(isValid(nX,nY)) {
							flag = false;
							break;
						}else {
							sum += map[nX][nY];
						}
					}
					if(flag) {
						result = Math.max(sum, result);
					}
				}
			}
		}
		return result;
	}
	
	private static boolean isValid(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= m;
	}
}