import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[] selected;
	static int N, result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// N명 중 N/2만큼 조합을 뽑는 메서드
		combination(0, 0);

		System.out.println(result);
	}

	private static void combination(int depth, int at) {
		// N/2만큼 뽑는다면 로직처리
		if (depth == N / 2) {
			result = Math.min(calcAbility(), result);
			if (result == 0) {
				System.out.println(0);
				System.exit(0);
			}
			return;
		}

		for (int i = at; i < N; i++) {
			// 이미 선택한 인원이라면 넘어감.
			if (selected[i])
				continue;

			// 선택 안 한 인원이라면 선택해줌
			selected[i] = true;
			// 선택 후 재귀 호출
			combination(depth + 1, i + 1);
			// 로직을 마친 뒤 원래 상태로 복귀
			selected[i] = false;
		}
	}

	// 능력치 차이를 계산하는 메서드
	private static int calcAbility() {
		int start = 0, link = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (selected[i] && selected[j]) {
					start += map[i][j] + map[j][i];
				} else if (!selected[i] && !selected[j]) {
					link += map[i][j] + map[j][i];
				}
			}
		}
		return Math.abs(start - link);
	}
}
