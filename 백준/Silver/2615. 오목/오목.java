import java.util.*;
import java.io.*;

public class Main {
	// 돌의 위치를 기억하는 클래스
	static class Point{
		int x;
		int y;

		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	// 최대길이
	static final int N = 20;
	// 오목판
	static int[][] board = new int[N][N];
	// 각 돌의 위치
	static ArrayList<Point> list = new ArrayList<>();
	// 상(0),하(1),좌(2),우(3),왼쪽위 대각선(4),오른쪽 아래 대각선(5),왼쪽아래 대각선(6), 오른쪽 위 대각선(7)
	static int[] dirX = {-1,1,0,0,-1,1,1,-1};
	static int[] dirY = {0,0,-1,1,-1,1,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 1; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] != 0) {
					list.add(new Point(i,j));
				}
			}
		}
		
		for(int i = 0; i < list.size();i++) {
			isValid(list.get(i));
		}
		
		System.out.println(0);
	}
	
	private static void isValid(Point point) {
		int x = point.x;
		int y = point.y;
		int color = board[x][y];
		int[] dirCount = new int[dirX.length];
		for(int i = 0; i < dirX.length; i++) {
			int nX = x + dirX[i];
			int nY = y + dirY[i];
			dirCount[i] = dfs(nX,nY,color,i);
		}
		
		// 위,아래
		if(dirCount[0] + dirCount[1] == 4) {
			resultPrint(x,y,0);
		}
		// 좌,우
		else if(dirCount[2] + dirCount[3] == 4) {
			resultPrint(x,y,2);
		}
		// 왼쪽 위, 오른쪽아래
		else if(dirCount[4] + dirCount[5] == 4) {
			resultPrint(x,y,4);
		}
		// 왼쪽아래 , 오른쪽 위
		else if(dirCount[6] + dirCount[7] == 4) {
			resultPrint(x,y,6);
		}
	}
	
	private static void resultPrint(int x,int y, int d) {
		int result = board[x][y];
		while(true) {
			int nX = x + dirX[d];
			int nY = y + dirY[d];
			if(nX <= 0 || nX >= N || nY <= 0 || nY >= N || board[nX][nY] != result) {
				break;
			}
			x = nX;
			y = nY;
		}
		System.out.println(result);
		System.out.println(x + " " + y);
		System.exit(0);
	}
	
	private static int dfs(int x,int y, int color, int d) {
		// 배열범위 밖이거나 색이 다르면 return 0;
		if(x <= 0 || x >= N || y <= 0 || y >= N || board[x][y] != color) {
			return 0;
		}
		
		// 색이 같다면
		return 1 + dfs(x + dirX[d], y + dirY[d],color,d);
	}
}

