import java.util.*;
import java.io.*;

public class Main {
	static int[] row = new int[9];
	static int[] col = new int[9];
	static int[][] sec = new int[3][3];
	static int[][] map = new int[9][9];
	static ArrayList<int[]> emptyList = new ArrayList<>();
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = input.charAt(j) - '0';
				if (map[i][j] == 0) {
					emptyList.add(new int[] { i, j });
				} else {
					int val = 1 << map[i][j];
					row[i] |= val;
					col[j] |= val;
					sec[i / 3][j / 3] |= val;
				}
			}
		}
		
		K = emptyList.size();

		solve(0);
	}

	private static void solve(int depth) {
		if (depth == K) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}

		int[] cur = emptyList.get(depth);
		int x = cur[0];
		int y = cur[1];
		int check = row[x] | col[y] | sec[x/3][y/3];
		for (int i = 1; i <= 9; i++) {
			if ((check & 1 << i) == 0) {
				map[x][y] = i;
				
				int val = 1 << i;
				row[x] |= val;
				col[y] |= val;
				sec[x / 3][y / 3] |= val;
				
				solve(depth + 1);
				
				row[x] -= val;
				col[y] -= val;
				sec[x / 3][y / 3] -= val;
			}
		}
		map[x][y] = 0;
	}
}
