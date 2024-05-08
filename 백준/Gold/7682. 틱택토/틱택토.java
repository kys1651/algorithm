import java.io.*;

public class Main {
	static final String invalid = "invalid";
	static final String valid = "valid";
	
	static char[][] map = new char[3][3];
	static boolean xCan, oCan;

	static int[] dirX = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dirY = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		String input;
		while (!(input = br.readLine()).equals("end")) {
			xCan = oCan = false;
			int xCount = 0, oCount = 0, noCount = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = input.charAt(i * 3 + j);
					if (map[i][j] == 'O') {
						oCount++;
					} else if (map[i][j] == 'X') {
						xCount++;
					} else {
						noCount++;
					}
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(map[i][j] == '.') continue;
					for(int k = 0; k < 8; k++) {
						int nX = i + dirX[k];
						int nY = j + dirY[k];
						int nnX = nX + dirX[k];
						int nnY = nY + dirY[k];
						if(isIn(nX,nY) && map[nX][nY] == map[i][j] && isIn(nnX,nnY) && map[nnX][nnY] == map[i][j]) {
							if(map[i][j] == 'O') {
								oCan = true;
							}else {
								xCan = true;
							}
							break;
						}
					}
				}
			}

			boolean result = false;
			if (xCan && !oCan && xCount == oCount + 1) {
				result = true;
			}
			if (!xCan && oCan && xCount == oCount) {
				result = true;
			}
			if (noCount == 0 && !xCan && !oCan && xCount == oCount + 1) {
				result = true;
			}
			if (result) {
				answer.append(valid);
			} else {
				answer.append(invalid);
			}
			answer.append('\n');
		}
		System.out.println(answer);
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < 3 && y >= 0 && y < 3;
	}
}