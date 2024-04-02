import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] answer = new int[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		solution(N);

		StringBuilder sb = new StringBuilder();
		for (int n : answer) {
			sb.append(n).append(' ');
		}
		System.out.println(sb);
	}

	private static void solution(int page) {
		int start = 1; // 시작 페이지
		int digit = 1; // 자릿수
		
		// 시작 페이지가 마지막 페이지보다 작은 경우
		while (start <= page) {
			// 1의자리가 9가 될 때까지 마지막 페이지 감소
			while (page % 10 != 9 && start <= page) {
				add(page, digit);
				page--;
			}
			
			if (page < start) {
				break;
			}

			// 1의 자리가 0이 될 때 까지 시작 페이지 1씩 증가
			while (start % 10 != 0 && start <= page) {
				add(start, digit);
				start++;
			}
			
			start /= 10;
			page /= 10;
			
			for (int i = 0; i < 10; i++) {
				answer[i] = answer[i] + (page - start + 1) * digit;
			}
			digit = digit * 10;
		}
	}

	// 자리수만큼 증가
	private static void add(int start, int digit) {
		while (start != 0) {
			answer[start % 10] += digit;
			start /= 10;
		}
	}
}
