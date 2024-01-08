import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	static int[][] map;
	static HashMap<Integer, String> command = new HashMap<>();
	static ArrayList<int[]> snake = new ArrayList<>();
	static int n,k,l;
	// 시계 방향으로 놓기
	static int[] dirX = {0,1,0,-1};
	static int[] dirY = {1,0,-1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			// -1은 사과를 뜻함
			map[x][y] = 1;
		}
		
		l = Integer.parseInt(br.readLine());
		for(int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String y = st.nextToken();
			command.put(x, y);
		}
		System.out.println(timeCheck());
	}
	private static int timeCheck() {
		int time = 0;
		int focus = 0;
		int cX = 0, cY = 0;
		snake.add(new int[] {0,0});
		
		while(true) {
			time++;
			int nX = cX + dirX[focus];
			int nY = cY + dirY[focus];
			
			// 벽에 부딪히면 끝
			if(nX < 0 || nX >= n || nY < 0 || nY >= n) {
				return time;
			}
			// 뱀에 부딪히면 끝
			for(int [] s : snake) {
				if(nX == s[0] && nY == s[1]) {
					return time;
				}
			}
			
			// 사과가 있다면 몸 길이는 늘어난다.
			if(map[nX][nY] == 1) {
				map[nX][nY] = 0;
				snake.add(new int[] {nX,nY});
			}
			// 사과가 없다면 몸이 줄어든다.
			else {
				snake.add(new int[] {nX,nY});
				snake.remove(0);
			}
			
			
			
			// 방향 변경
			if(command.containsKey(time)) {
				if(command.get(time).equals("D")){
					focus++;
					if(focus == 4) {
						focus = 0;
					}
				}else {
					focus--;
					if(focus == -1) {
						focus = 3;
					}
				}
			}
			cX = nX;
			cY = nY;
		}
	}
}
