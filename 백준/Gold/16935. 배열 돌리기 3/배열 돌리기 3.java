import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, rLen, cLen;
	static int[][] map;
	static int[][][] tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		rLen = N;
		cLen = M;
		st.nextToken();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		String[] commands = br.readLine().split(" ");
		for (String command : commands) {
			if (command.equals("1")) {
				oper1();
			} else if (command.equals("2")) {
				oper2();
			} else if (command.equals("3")) {
				oper3();
			} else if (command.equals("4")) {
				oper4();
			} else if (command.equals("5")) {
				oper5();
			} else if (command.equals("6")) {
				oper6();
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rLen; i++) {
			for (int j = 0; j < cLen; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static void print() {
		for (int[] ns : map) {
			for (int n : ns) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

	// 1. 상하반전 로직
	private static void oper1() {
		for (int i = 0; i < rLen / 2; i++) {
			int[] tmp = map[i];
			map[i] = map[rLen - 1 - i];
			map[rLen - 1 - i] = tmp;
		}
	}

	// 2. 좌우반전 로직
	private static void oper2() {
		for (int i = 0; i < cLen / 2; i++) {
			// 값 위치 변경
			for (int j = 0; j < rLen; j++) {
				int tmp = map[j][i];
				map[j][i] = map[j][cLen - 1 - i];
				map[j][cLen - 1 - i] = tmp;
			}
		}
	}

	// 3. 오른쪽 90도 회전 로직
	private static void oper3() {
		int[][] tmpMap = new int[cLen][rLen];
		for (int i = 0; i < cLen; i++) {
			for (int j = 0; j < rLen; j++) {
				tmpMap[i][j] = map[rLen - 1 - j][i];
			}
		}
		map = tmpMap;
		swap();
	}

	// 4. 왼쪽 90도 회전 로직
	private static void oper4() {
		int[][] tmpMap = new int[cLen][rLen];
		for (int i = 0; i < cLen; i++) {
			for (int j = 0; j < rLen; j++) {
				tmpMap[i][j] = map[j][cLen - i - 1];
			}
		}
		map = tmpMap;
		swap();
	}

	// 5. 분면 시계방향 회전 로직
	private static void oper5() {
		load(rLen / 2, cLen / 2);
		int[][] tmpArr = tmp[2];
		tmp[2] = tmp[3];
		tmp[3] = tmp[1];
		tmp[1] = tmp[0];
		tmp[0] = tmpArr;

		save();
	}

	
	// 6. 분면 반시계 방향 회전 로직
	private static void oper6() {
		load(rLen / 2, cLen / 2);
		int tmpArr[][] = tmp[0];
		tmp[0] = tmp[1];
		tmp[1] = tmp[3];
		tmp[3] = tmp[2];
		tmp[2] = tmpArr;
		
		save();
	}

	private static void load(int tmpRLen, int tmpCLen) {
		tmp = new int[4][tmpRLen][tmpCLen];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int l = 0; l < tmpRLen; l++) {
					for (int k = 0; k < tmpCLen; k++) {
						tmp[i * 2 + j][l][k] = map[i * tmpRLen + l][j * tmpCLen + k];
					}
				}
			}
		}
	}

	private static void save() {
		for (int l = 0; l < 2; l++) {
			for (int k = 0; k < 2; k++) {
				for (int i = 0; i < rLen / 2; i++) {
					for (int j = 0; j < cLen / 2; j++) {
						map[l * (rLen / 2) + i][k * (cLen / 2) + j] = tmp[l * 2 + k][i][j];
					}
				}
			}
		}
	}
	
	private static void swap() {
		int tmp = rLen;
		rLen = cLen;
		cLen = tmp;
	}
}
