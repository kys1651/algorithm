import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 현재 상승하는 부분 찾기
		int i = n - 1;
		while (i - 1 >= 0 && arr[i - 1] <= arr[i]) {
			i--;
		}

		// i가 0이라면 더 이상 찾을 수 없는 것
		if (i == 0) {
			System.out.println(-1);
			return;
		}

		// 처음으로 만나는 i-1(swap 할 값)보다 작은 값과 교환
		int j = n-1;
		for(; arr[i-1] < arr[j]; j--) {}
		swap(arr, i - 1, j);

		// 뒷 부분 정렬을 위해서 전부 swap 
		for (j = n - 1; i < j; i++, j--) {
			swap(arr, i, j);
		}

		// Stringbuilder에 추가
		StringBuilder sb = new StringBuilder();
		for (int a : arr) {
			sb.append(a).append(' ');
		}
		System.out.println(sb);
	}

	// 배열의 원소를 교환
	private static void swap(int[] p, int i, int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
}
