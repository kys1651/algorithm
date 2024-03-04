import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return age - o.age;
		}
	}

	static int N, M;
	static int[][] A, addA;
	static Queue<Tree> trees = new LinkedList<>();
	static Queue<Tree> dieTree = new LinkedList<>();

	// CW
	static int[] dirX = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dirY = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// A Input
		addA = new int[N][N];
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				addA[i][j] = Integer.parseInt(st.nextToken());
				A[i][j] = 5;
			}
		} // A Input End

		// tree Input
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			trees.add(new Tree(x, y, age));
		} // tree Input End
		Collections.sort((List<Tree>) trees);

		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(trees.size());
	}

	private static void spring() {
		int size = trees.size();
		while (size-- > 0) {
			Tree t = trees.poll();
			if (A[t.x][t.y] - t.age >= 0) {
				A[t.x][t.y] -= t.age;
				trees.add(new Tree(t.x, t.y, t.age + 1));
			} else {
				dieTree.add(t);
			}
		}
	}

	private static void summer() {
		while (!dieTree.isEmpty()) {
			Tree t = dieTree.poll();
			A[t.x][t.y] += t.age / 2;
		}
	}

	private static void fall() {
		int size = trees.size();
		ArrayList<Tree> tmp = new ArrayList<>();

		while (size-- > 0) {
			Tree t = trees.poll();
			tmp.add(t);
			if (t.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int nX = t.x + dirX[i];
					int nY = t.y + dirY[i];
					if (isIn(nX, nY)) {
						trees.add(new Tree(nX, nY, 1));
					}
				}
			}
		}

		for (Tree t : tmp) {
			trees.add(t);
		}

	}

	private static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] += addA[i][j];
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
