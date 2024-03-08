import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] maxCount;

	// 가능한 위치를 전부 놓아두기
	static ArrayList<int[]>[] emptyList;
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 0 흰색, 1검은색
		maxCount = new int[2];
		emptyList = new ArrayList[2];
		emptyList[0] = new ArrayList<>();
		emptyList[1] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				int tmp = input.charAt(j * 2) - '0';
				// 놓을 수 있는 위치 전부 기억하기
				if (tmp == 1) {
					int idx = i % 2 + j + 1;
					// 짝수 인덱스: 검정
					if (idx % 2 == 0) {
						emptyList[1].add(new int[] { i, j });
					}
					// 홀수 인덱스 : 흰색
					else {
						emptyList[0].add(new int[] { i, j });
					}
				}
			}
		}
		visit = new int[emptyList[1].size()];
		solve(0, 0, 1);

		visit = new int[emptyList[0].size()];
		solve(0, 0, 0);
		System.out.println(maxCount[0] + maxCount[1]);
	}

	private static void solve(int depth, int count, int isColor) {
		if (count + emptyList[isColor].size() - depth <= maxCount[isColor]) {
			return;
		}

		// 끝이면 최대값 갱신
		if (depth == emptyList[isColor].size()) {
			for (int i = 0; i < depth; i++) {
				if (visit[i] != 0) {
					maxCount[isColor] = Math.max(maxCount[isColor], count);
					break;
				}
			}
			return;
		}

		// 갈 수 있다면 가고 해당 위치에 방문처리
		if (visit[depth] == 0) {
			fill(depth, isColor);
			solve(depth + 1, count + 1, isColor);
			fill(depth, isColor);
		}

		// 여기 안놓는게 더 좋은 경우 있을수도 있음
		solve(depth + 1, count, isColor);
	}

	// (x,y) 위치에 비숍을 놓을 수 있는가
	private static void fill(int idx, int isColor) {
		int[] pos = emptyList[isColor].get(idx);
		int value = idx + 1;
		for (int i = 0; i < emptyList[isColor].size(); i++) {
			if (visit[i] != value && visit[i] != 0) {
				continue;
			}
			int nextPos[] = emptyList[isColor].get(i);
			if (Math.abs(nextPos[0] - pos[0]) == Math.abs(nextPos[1] - pos[1])) {
				if (visit[i] == 0) {
					visit[i] = value;
				} else {
					visit[i] = 0;
				}
			}
		}
	}
}
