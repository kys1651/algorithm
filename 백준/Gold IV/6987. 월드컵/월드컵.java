import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int SIZE = 6;

	static StringBuilder sb = new StringBuilder();

	static int[] win = new int[SIZE];
	static int[] draw = new int[SIZE];
	static int[] lose = new int[SIZE];
	static boolean result;
	// 일어날 수 있는 경우의 수
	static int[][] match = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 },
			{ 2, 3 }, { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				win[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
			}

			result = false;

			combination(0);

			if (result) {
				sb.append(1);
			} else {
				sb.append(0);
			}

			sb.append(' ');
		}
		System.out.println(sb);
	}

	// 여기서는 승점만 따진다.
	private static void combination(int depth) {
		if (result)
			return;

		if (depth == 15) {
			for(int i = 0; i < 6; i++) {
				if(win[i] != 0 || draw[i] != 0 || lose[i] != 0) {
					return;
				}
			}
			result = true;
			return;
		}

		int a = match[depth][0];
		int b = match[depth][1];

		// a가 이김
		win[a]--;
		lose[b]--;
		if(win[a] >= 0 && lose[b] >= 0) {
			combination(depth + 1);
		}
		win[a]++;
		lose[b]++;

		// 무승부
		draw[a]--;
		draw[b]--;
		if(draw[a] >= 0 && draw[b] >= 0) {
			combination(depth + 1);
		}
		draw[a]++;
		draw[b]++;

		// b가 이긴 경우
		win[b]--;
		lose[a]--;
		if(win[b] >= 0 && lose[a] >= 0) {
			combination(depth + 1);
		}
		win[b]++;
		lose[a]++;
	}
}
