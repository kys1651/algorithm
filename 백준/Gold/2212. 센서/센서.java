import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		// 집중국이 같거나 더 많다면 하나씩 커버해주면 된다
		if(n <= k) {
			System.out.println(0);
			return;
		}
		
		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}// Input End
		
		// 좌표값 정렬
		Arrays.sort(arr);
		
		// 0~n까지 차이값들을 저장 후 정렬
		int[] gap = new int[n-1];
		for(int i = 0; i < n-1; i++) {
			gap[i] = arr[i+1]-arr[i];
		}
		// 차이값 정렬
		Arrays.sort(gap);
		
		// K-1개를 집중국들이 커버 가능하니 k-1만큼 건너띄우고 싼 비용만큼 더해준다.
		int sum = 0;
		for(int i = n - k - 1; i >= 0 ; i--) {
			sum = sum + gap[i];
		}
		System.out.println(sum);
	}
}
