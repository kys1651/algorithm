import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] s,b;
	static int N,result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = new int[N];
		b = new int[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		// 재료가 한개라면 값을 바로 출력 후 종료
		if(N == 1) {
			System.out.println(Math.abs(s[0] - b[0]));
			return;
		}
		
		/**
		 * 비트마스크를 이용한 풀이
		 */
		// 재료는 최소한개임으로 0을 제외하고 2^n - 1까지 확인하면된다.(하나도 사용하지 않은 경우,사용한 경우)
		for(int i = 1; i < (1 << N); i++) {
			int sSum = 1, bSum = 0;
			for(int j = 0; j < N;j++){
				// 1의 위치를 왼쪽으로 시프트해주면서 1값을 찾는다. (1을 제외한 나머지 비트는 마스크 오프)
				// 만약 비트가 1이라면 결과값이 같아야 한다
				if((i & (1 << j)) == (1 << j)) {
					// 비트가 on이라면 연산
					sSum *= s[j];
					bSum += b[j];
				}
			}
			// 최소값 찾기 -> 0을 발견하면 종료(신맛과 단맛이 같은 경우)
			result = Math.min(result, Math.abs(sSum-bSum));
			if(result == 0)
			{
				System.out.println(0);
				return;
			}
		}
		System.out.println(result);
	}
}
