import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] chs = br.readLine().toCharArray();
		num = new int[4];

		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum += num[i];
		}

		// 넣어야 할 수의 합이 0이면 모든 경우의 수 가능
		if (sum == 0) {
			System.out.println(S - P + 1);
			return;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		int left = 0, right = 0;
		// 현재 주어진 가장 첫번째 부분 문자열 확인
		for (; right < P; right++) {
			num[map.get(chs[right])]--;
		}

		int count = 0;
		while (left <= S - P) {
			if (isValidPw()) {
				count++;
			}
			num[map.get(chs[left++])]++;
			num[map.get(chs[right])]--;
			if(right != S-1) {
				right++;
			}
		}
		
		System.out.println(count);
	}

	static private boolean isValidPw() {
		for (int i = 0; i < 4; i++) {
			if (num[i] > 0) {
				return false;
			}
		}
		return true;
	}
}
