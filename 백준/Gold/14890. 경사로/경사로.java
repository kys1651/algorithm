import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		// Input
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j * 2) - '0';
			}
		} // Input End

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (isColPath(i)) {
				count++;
			}
			if (isRowPath(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean isRowPath(int pos) {
		int count = 0;
		int prev = 0;
		for (int i = 0; i < N - 1; i++) {
			// 이전에 나온 값이 없다면 현재 위치 기준으로 1
			// -1이라면 갱신하면 안됨으로 0
			if (map[i][pos] != prev) {
				count = prev == -1 ? 0 : 1;
				prev = map[i][pos];
			}

			int cur = map[i][pos];
			int next = map[i + 1][pos];
			if (cur < next) {
				// 높이의 차이가 1보다 크거나 현재 나온 높이가 L보다 작다면 false
				if (cur + 1 != next || count < L) {
					return false;
				}
			} else if (cur > next) {
				// 높이의 차이가 1보다 크거나 남아있는 길이가 L만큼이 아니라면 false
				if (cur - 1 != next || i + L >= N) {
					return false;
				}
				for (int j = 1; j <= L; j++) {
					// next와 값이 다르다면 false
					if (map[i + j][pos] != next) {
						return false;
					}
				}
				// 경사로 내려온 위치로 옮겨준다.
				i += L - 1;
				prev = -1;
			} else {
				// 다음과 같다면 count 증가
				count++;
			}
		}
		return true;
	}

	private static boolean isColPath(int pos) {
		int[] arr = map[pos];

		int count = 0;
		int prev = 0;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] != prev) {
				count = prev == -1 ? 0 : 1;
				prev = arr[i];
			}

			int cur = arr[i];
			int next = arr[i + 1];
			if (cur < next) {
				// 높이 차이가 1이 아니거나 || 현재위치가 L만큼 안나왔다면 경사로 설치 불가
				if (cur + 1 != next || count < L) {
					return false;
				}
			}
			// 다음이 현재보다 작다면
			else if (cur > next) {
				// 차이가 1이 아니거나 || 남아있는 거리가 L이 아니면 false
				if (cur - 1 != next || i + L >= N) {
					return false;
				}

				// i+1부터 i+L까지 map[pos][i+1]과 같은 높이인지 확인
				for (int j = 1; j <= L; j++) {
					if (map[pos][i + j] != map[pos][i + 1]) {
						return false;
					}
				}
				// 같다면 위치를 변경해준다.
				i += L - 1;
				prev = -1;
			} else {
				count++;
			}
		}
		return true;
	}
}
