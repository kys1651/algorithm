import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, result = Integer.MAX_VALUE;
	static int[][] map;

	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> house = new ArrayList<>();
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		// Input
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chicken.add(new int[] { i, j });
				} else if (map[i][j] == 1) {
					house.add(new int[] { i, j });
				}
			}
		} // Input End

		K = chicken.size();
		check = new boolean[K];

		combination(0, 0);

		System.out.println(result);
	}

	private static void combination(int depth, int at) {
		if (depth == M) {
			calc();
			return;
		}

		for (int i = at; i < K; i++) {
			if (check[i])
				continue;
			check[i] = true;
			combination(depth + 1, i + 1);
			check[i] = false;
		}
	}

	private static void calc() {
		int sum = 0;
		for (int[] h : house) {
			int tmp = result;
			for (int i = 0; i < K; i++) {
				if (!check[i])
					continue;
				tmp = Math.min(tmp, getDistance(h, chicken.get(i)));
			}
			sum += tmp;
			if (sum > result)
				return;
		}
		result = sum;
	}

	private static int getDistance(int[] h, int[] c) {
		return Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
	}
}
