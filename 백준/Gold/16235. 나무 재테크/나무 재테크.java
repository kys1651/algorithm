import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int age;
		boolean die;

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
	static ArrayList<Tree> treeList = new ArrayList<>();
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
			treeList.add(new Tree(x, y, age));
		} // tree Input End

		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(treeList.size());
	}

	private static void spring() {
		Collections.sort(treeList);
		for (int i = 0; i < treeList.size(); i++) {
			Tree t = treeList.get(i);

			if (A[t.x][t.y] - t.age >= 0) {
				A[t.x][t.y] -= t.age;
				t.age++;
			} else {
				dieTree.add(t);
				t.die = true;
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
		ArrayList<Tree> tmp = new ArrayList<>();
		for (Tree t : treeList) {
			if (t.die)
				continue;
			if (t.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int nX = t.x + dirX[i];
					int nY = t.y + dirY[i];
					if (isIn(nX, nY)) {
						tmp.add(new Tree(nX, nY, 1));
					}
				}
			}
			tmp.add(t);
		}
		treeList = tmp;

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
