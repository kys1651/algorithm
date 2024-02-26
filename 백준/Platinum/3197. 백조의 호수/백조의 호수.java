import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] start, end; // 시작지점에서 출발하는 북극과 종료지점에서 출발하는 남극
	static char[][] map; // 빙하 상태
	static int R, C; // 빙하 길이

	// 물의 위치
	static Queue<int[]> water = new LinkedList<>();
	// 움직이는 위치
	static Queue<int[]> check = new LinkedList<>();

	// 상,하,좌,우로 움직인다.
	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// Input
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				// 빙하가 아니라면 전부 물이다. 사람 포함
				if (map[i][j] != 'X') {
					water.add(new int[] { i, j });
				}
				// 사람이라면 위치 저장해놓기
				if (map[i][j] == 'L') {
					int[] tmp = new int[] { i, j };
					check.add(tmp);
					if (start == null) {
						start = tmp;
						map[i][j] = 'S';
					} else {
						end = tmp;
						map[i][j] = 'E';
					}
				}
			}
		}// Input End

		// 시간은 0부터 시작
		int time = 0;
		
		// 만날 수 있는지 확인
		while (!checkMeet()) {
			// 못만난다면 시간 증가 후 얼음 녹이기
			time++;
			removeIce();
		}
		
		System.out.println(time);
	}
	
	// 얼음 제거 로직
	private static void removeIce() {
		// 하루 단위로 진행하기 때문에 size만큼만
		int size = water.size();
		for(int s = 0; s < size; s++) {
			int[] cur = water.poll();
			
			for(int i = 0; i < 4; i++) {
				int nX = cur[0] + dirX[i];
				int nY = cur[1] + dirY[i];
				// 방문한 곳이라면 넘어간다.
				if(!isIn(nX,nY)) {
					continue;
				}
				
				// 빙하라면 녹여주고 큐에 삽입. -> 다음 메서드에 다시 녹여줄 위치를 저장하는 것이다.
				if(map[nX][nY] == 'X') {
					map[nX][nY] = '.';
					water.add(new int[] {nX,nY});
				}
			}
		}
	}

	private static boolean checkMeet() {
		Queue<int[]> tmp = new LinkedList<>();

		// 큐가 빌 때 까지
		while (!check.isEmpty()) {
			// 현재 위치와 마크
			int[] cur = check.poll();
			char mark = map[cur[0]][cur[1]];

			// 상하좌우
			for (int i = 0; i < 4; i++) {
				int nX = cur[0] + dirX[i];
				int nY = cur[1] + dirY[i];
				
				// 배열 밖이거나 || 방문한 곳이라면 넘어간다.
				if (!isIn(nX, nY) || map[nX][nY] == mark) {
					continue;
				}
				
				// 만날 수 있다면 종료
				if (mark == 'S' && map[nX][nY] == 'E') {
					return true;
				}
				if (mark == 'E' && map[nX][nY] == 'S') {
					return true;
				}
				
				// 빙산이라면 tmp에 넣어줌( 더 이상 못가기 때문에 다음 메서드에 진행하기 위해서 )
				if (map[nX][nY] == 'X') {
					tmp.add(new int[] { cur[0], cur[1] });
				}
				// 갈 수 있는 곳이라면 간다.
				if (map[nX][nY] == '.') {
					map[nX][nY] = mark;
					check.add(new int[] { nX, nY });
				}
			}
		}

		// 임시로 저장한 위치를 다시 check 큐에 넣어줌
		while (!tmp.isEmpty()) {
			check.add(tmp.poll());
		}

		// 만나지 못했음으로 false
		return false;
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
