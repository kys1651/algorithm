import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Operator {
		int r;
		int c;
		int s;

		public Operator(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	static int N, M, K, answer = 5000;
	static int[][] map;
	static Operator[] oper;
	static boolean[] visit;
	static int[] execute;
	static int[] dirX = { 0, 1, 0, -1 };
	static int[] dirY = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		oper = new Operator[K];
		visit = new boolean[K];
		execute = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			oper[i] = new Operator(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		combination(0);

		System.out.println(answer);
	}

	private static void combination(int depth) {
		if (depth == K) {
			int[][] copyMap = new int[N][M];
			for(int i = 0; i < N; i++) {
				copyMap[i] = Arrays.copyOf(map[i],M);
			}
			executeRotate();
			
			
			// 배열의 최대 값 찾기
			for (int i = 0; i < N; i++) {
				int tmp = 0;
				for (int j = 0; j < M; j++) {
					tmp += map[i][j];
				}
				if (answer > tmp)
					answer = tmp;
			}
			
			map = copyMap;
			return;
		}

		for (int i = 0; i < K; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			execute[depth] = i;
			combination(depth + 1);
			visit[i] = false;
		}

	}

	private static void executeRotate() {
		for (int i = 0; i < K; i++) {
			Operator cur = oper[execute[i]];
			int startX = cur.r - cur.s - 1;
			int startY = cur.c - cur.s - 1;
			int endX = cur.r + cur.s - 1;
			int endY = cur.c + cur.s - 1;
			int len = 2 * cur.s + 1;
			for (int j = 0; j < len / 2; j++) {
				rotate(startX + j, startY + j, endX - j, endY - j);
			}
		}
		
		
//		for(int[] ns : map) {
//			for(int n : ns) {
//				System.out.print(n + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("=================");
	}

	private static void rotate(int startX, int startY, int endX, int endY) {
		int prev = map[startX][startY];
		int x = startX + dirX[0];
		int y = startY + dirY[0];
		int d = 0;
		while (startX != x || startY != y) {
			int nX = x + dirX[d];
			int nY = y + dirY[d];

			if (nX < startX || nX > endX || nY < startY || nY > endY) {
				d = (d + 1) % 4;
				nX = x + dirX[d];
				nY = y + dirY[d];
			}
			
			int tmp = map[x][y];
			map[x][y] = prev;
			prev = tmp;
			x = nX;
			y = nY;
		}
		map[x][y] = prev;
	}
}
