import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] alphabet;
	static char[] answer;
	static StringBuilder sb = new StringBuilder();
	static HashSet<Character> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = new char[L];
		alphabet = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alphabet);
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		combination(0, 0);
		System.out.println(sb);
	}

	private static void combination(int depth, int at) {
		if (depth == L) {
			check();
			return;
		}

		for (int i = at; i < C; i++) {
			answer[depth] = alphabet[i];
			combination(depth + 1, i + 1);

		}
	}

	private static void check() {
		int j = 0;
		int m = 0;
		for (char ch : answer) {
			if (set.contains(ch)) {
				m++;
			} else {
				j++;
			}
			if (j >= 2 && m >= 1) {
				sb.append(answer).append('\n');
				return;
			}
		}
	}
}
