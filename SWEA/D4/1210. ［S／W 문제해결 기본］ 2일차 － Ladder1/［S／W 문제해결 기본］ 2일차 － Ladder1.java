import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = 10;
		final int SIZE = 100;
		for(int tc = 1; tc<= T; tc++) {
			br.readLine();
			int [][] map = new int[SIZE][SIZE];
			
			for(int i = 0; i < SIZE; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < SIZE; j++) {
					map[i][j] =Integer.parseInt(st.nextToken());
				}
			}
			
			int start = 0;
			for(int i =0; i < SIZE; i++) {
				if(map[SIZE-1][i] == 2) {
					start = i;
				}
			}
			
			int i = SIZE-1, j = start;
			while(i != 0) {
				// 왼쪽으로 길이 열렸을 경우
				if(j-1>=0 && map[i][j-1] == 1) {
					while(j - 1 >= 0 && map[i][j-1] == 1) {
						j--;
					}
				}else if(j + 1 < SIZE && map[i][j+1] == 1) {
					while(j+1 < SIZE && map[i][j+1] == 1) {
						j++;
					}
				}
				i--;
			}
			sb.append("#").append(tc).append(" ").append(j).append("\n");
		}
		System.out.println(sb);
	}

}
