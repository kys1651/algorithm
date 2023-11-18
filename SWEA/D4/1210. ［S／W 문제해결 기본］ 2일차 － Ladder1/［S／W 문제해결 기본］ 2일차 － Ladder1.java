import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int[][] map = new int[100][100];
			int endX = 0;
			int endY = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2){
						endX = i;
						endY = j;
					}
				}
			}
			System.out.println("#" + tc + " " + check(endX, endY,map));
		}
	}

	private static int check(int startX, int startY, int[][] map) {
		int curX = startX;
		int curY = startY;
		while(curX > 0) {
			curX -= 1;
			if(curY - 1 >= 0 && map[curX][curY - 1] == 1) {
				while(curY - 1>= 0 && map[curX][curY-1] == 1) {
					curY--;
				}
			}
			else if(curY + 1 < map.length && map[curX][curY+1] == 1) {
				while(curY + 1 < map.length && map[curX][curY+1] == 1) {
					curY++;
				}
			}
		}
		return curY;
	}
}