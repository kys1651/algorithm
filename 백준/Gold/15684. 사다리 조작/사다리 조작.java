import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result, N, M, H;
	static int[][] line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		line = new int[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 두개를 서로 연결 시켜준다.
			line[a][b] = b + 1;
			line[a][b + 1] = b;
		}
		result = Integer.MAX_VALUE;
		lineInstall(0);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	//
	private static void lineInstall(int count) {
		// 현재 설치한 경로에서 각 줄로 갈 수 있는지 확인하는 메서드
		if (isPossible()) {
			// count가 0이라면 최소값
			if (count == 0) {
				System.out.println(0);
				System.exit(0);
			}
			// 현재 경로에서 각 줄로 갈 수 있다면 결과값 갱신 후 return;
			result = Math.min(result, count);
			return;
		}

		// count가 3이라면 더 큰 값은 의미가 없음
		if (count == 3) {
			return;
		}

		// 행
		for (int i = 1; i <= H; i++) {
			for (int j = 2; j <= N; j++) {
				// 왼쪽을 바라보는 방향으로 설치가 가능한지만 확인하면 된다.(마지막은 오른쪽으로 설치 못하기에)
				int left = j - 1;

				// 현재 위치와 왼쪽 세로선이 모두 비어있다면 연결하기
				if (line[i][j] == 0 && line[i][left] == 0) {
					// 설치할 수 있는 곳이라면 연결해준다.
					line[i][j] = left;
					line[i][left] = j;
					lineInstall(count + 1);
					// 다시 줄을 초기화 시켜줌
					line[i][j] = line[i][left] = 0;
				}
			}
		}
	}

	// 현재 상태로 i -> i로 내려갈 수 있는지 확인하는 메서드
	private static boolean isPossible() {
		for (int i = 1; i <= N; i++) {
			// 출발 지점 설정
			int x = 1, y = i;
			// 현재 x가 끝까지 내려간다면
			for (; x <= H; x++) {
				// 연결안된다면 쭉 내려간다.
				if (line[x][y] == 0)
					continue;
				// 연결된 곳을 찾았다면 y로 이동함
				y = line[x][y];
			}

			if (i != y) {
				return false;
			}
		}
		return true;
	}

}
