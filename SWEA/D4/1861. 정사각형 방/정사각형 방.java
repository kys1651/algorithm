import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제: D4_1861_ 정사각형방
 * 
 * @author 김용수 메모리: 91348kb 실행시간: 562ms
 * 
 *         접근 방법: 1. 큰수를 기준으로 -1인 곳을 갱신해준다. 그러면 배열에는 출발점에서 갈 수 있는 개수가 저장됨 2.
 *         bfs를 통해 갱신을 해준 뒤 로직을 마치면 배열을 돌면서 가장 큰 값을 찾아 갱신해준다.
 *
 */
public class Solution {
	static int n;
	// 맵과 값을 저장하는 배열
	static int[][] map, visit;
	// 방향을 저장하는 배열
	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 입력받음
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());

			// 배열 생성 및 값 할당
			map = new int[n][n];
			visit = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 배열값이 0이라면(초기값이라면) bfs를 통해서 값을 할당해줌
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j] == 0) {
						bfs(i, j);
					}
				}
			}

			// 배열에서 가장 큰 값을 찾아서 갱신한다.
			int startNum = 0, maxCount = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j] > maxCount) {
						maxCount = visit[i][j];
						startNum = map[i][j];
					} else if (visit[i][j] == maxCount) {
						startNum = Math.min(map[i][j], startNum);
					}
				}
			}
			// 출력
			sb.append(String.format("#%d %d %d\n", tc, startNum, maxCount));
		}
		System.out.println(sb);

	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		// 현재 위치 1로 할당
		visit[x][y] = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nX = cur[0] + dirX[i];
				int nY = cur[1] + dirY[i];
				// 배열 범위밖이거나 -1만큼차이가 안난다면 넘어가기
				if (!isCheck(nX, nY) || map[nX][nY] != map[cur[0]][cur[1]] - 1) {
					continue;
				}
				// 
				visit[nX][nY] = visit[cur[0]][cur[1]] + 1;
				queue.offer(new int[] { nX, nY });
			}
		}
	}

	// 배열 범위 밖을 확인하는 로직
	private static boolean isCheck(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

}
