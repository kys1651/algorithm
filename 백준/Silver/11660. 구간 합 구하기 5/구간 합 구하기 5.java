import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : BJ_11660_구간 합 구하기 5
 * @author 김용수
 * 제출한 시간 :
 * 메모리 : 
 * 시간 :
 * 
 * 접근 방법 :
 * 1. N은 1024가 최대값이다. 2차원 배열임으로 1024*1024 = 1,048,576
 * 2. 이에 대해서 M이 100,000이라면 100,0000 * 1048576 = 1초라는 시간이 담지 못해서 시간초과이다.
 * 3. 누적합을 이용해서 풀어주면 된다.
 * 4. 현재 행은 이전행과 이전열을 더한 값이다.
 * 5. 결과를 출력 할 때는 end값(x2,y2)에서 (x2,y1-1),(x1-1,y2) 만큼 빼준다. (구간합에서 더하지 않아도 될 곳을 빼줌)
 * 6. 그 후 (x1-1,y1-1)을 더해준다. (빼주는 과정에서 두번 값이 빠졌으므로 더해줌)
 */
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				// i,j에 이전 행과 열을 더해서 넣어준다.
				map[i][j] = Integer.parseInt(st.nextToken()) + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(map[x2][y2] - map[x2][y1] - map[x1][y2] + map[x1][y1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
