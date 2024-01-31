import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 접근 방법
 * 1. 만약 N과 M이 100,000인 경우 전부 조회하는 시간 복잡도는 10,000,000,000 = 10^9 -> 시간 초과
 * 2. 누적합을 이용해서 i,와j를 입력받으면 j인덱스값에서 i -1 값을 빼준다.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] num = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int value = Integer.parseInt(st.nextToken());
			// 현재 값은 이전 누적값 + 현재 값
			num[i] = num[i-1] + value;
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(num[end] - num[start-1]).append("\n");
		}
		System.out.println(sb);
	}
}
