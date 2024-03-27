import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] seq = new int[N];
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		} // Input End

		int[] lis = new int[N];
		lis[0] = seq[0];
		int idx = 1;

		for (int i = 1; i < N; i++) {
			// lis값 중 가장 큰 값이 현재 들어온 값보다 작은 경우
			if (lis[idx - 1] < seq[i]) {
				// lis에 추가해주면 된다.
				lis[idx++] = seq[i];
			}
			// lis첫번째보다 작은 경우
			else if (lis[0] > seq[i]) {
				// 대치
				lis[0] = seq[i];
			}
			// 그 외에 중간에 넣어야하는 경우
			else {
				// 0 ~ idx - 1(lis범위내에서 어디에 넣어야할지 찾아준 뒤 그곳에 넣어준다.)
				int left = 0, right = idx - 1;
				while (left <= right) {
					int mid = (left + right) >> 1;
					if (lis[mid] < seq[i]) {
						left = mid + 1;
					} else if (lis[mid] > seq[i]) {
						right = mid - 1;
					} else {
						// 같은 값일 경우 그냥 위치 기억 후 종료해주면 된다.
						left = mid;
						break;
					}
				}
				lis[left] = seq[i];
			}
		}
		System.out.println(idx);
	}
}
