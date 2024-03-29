import java.io.*;
import java.util.*;

public class Main {
	static int[] table;
	static char[] code;
	static HashMap<Character, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			code = br.readLine().toCharArray();
			map = new HashMap<>();
			for (int i = 0; i < code.length; i++) {
				map.put(code[i], i);
			}

			String W = br.readLine();
			String S = br.readLine();
			makeTable(W);

			ArrayList<Integer> answer = new ArrayList<>();
			for (int i = 0; i < code.length; i++) {
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
		char last = code[code.length - 1];
		for (int i = code.length - 1; i >= 1; i--) {
			code[i] = code[i - 1];
		}
		code[0] = last;
	}

	private static void makeTable(String keyword) {
		int keywordSize = keyword.length();
		table = new int[keywordSize];
		int j = 0;
		for (int i = 1; i < keywordSize; i++) {
			while (j > 0 && keyword.charAt(i) != keyword.charAt(i)) {
				j = table[j - 1];
			}
			if (keyword.charAt(i) == keyword.charAt(j)) {
				table[i] = ++j;
			}
		}
	}

	private static boolean KMP(String text, String keyword) {
		int count = 0;
		int textSize = text.length();
		int keywordSize = keyword.length();
		int j = 0;
		for (int i = 0; i < textSize; i++) {
			char textChar = code[map.get(text.charAt(i))];
			while (j > 0 && textChar != keyword.charAt(j)) {
				j = table[j - 1];
			}
			if (textChar == keyword.charAt(j)) {
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
