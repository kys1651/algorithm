import java.io.*;
import java.util.*;

public class Main {
	static char[] A, W, S;
	static HashMap<Character, Character> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			A = br.readLine().toCharArray();
			W = br.readLine().toCharArray();
			S = br.readLine().toCharArray();

			for (int i = 0; i < A.length; i++) {
				map.put(A[i], A[(i + 1) % A.length]);
			}

			ArrayList<Integer> answer = new ArrayList<>();
			for (int i = 0; i < A.length; i++) {
				if (KMP(S, W)) {
					answer.add(i);
				}
				shiftCode();
			}

			if (answer.size() == 0) {
				sb.append("no solution");
			} else if (answer.size() == 1) {
				sb.append("unique: " + answer.get(0));
			} else {
				sb.append("ambiguous: ");
				for (int a : answer) {
					sb.append(a).append(' ');
				}
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void shiftCode() {
		for (int i = 0; i < W.length; i++) {
			W[i] = map.get(W[i]);
		}
	}

	private static int[] makeTable(char[] pattern) {
		int patternSize = pattern.length;
		int[] table = new int[patternSize];
		int j = 0;
		for (int i = 1; i < patternSize; i++) {
			while (j > 0 && pattern[i] != pattern[i]) {
				j = table[j - 1];
			}
			if (pattern[i] == pattern[j]) {
				table[i] = ++j;
			}
		}
		return table;
	}

	private static boolean KMP(char[] text, char[] keyword) {
		int[] table = makeTable(keyword);
		int count = 0;
		int textSize = text.length;
		int keywordSize = keyword.length;
		int j = 0;
		for (int i = 0; i < textSize; i++) {
			while (j > 0 && text[i] != keyword[j]) {
				j = table[j - 1];
			}
			if (text[i] == keyword[j]) {
				if (j == keywordSize - 1) {
					count++;
					j = table[j];
					if (count == 2) {
						break;
					}
				} else {
					j++;
				}
			}
		}
		return count == 1;
	}
}
