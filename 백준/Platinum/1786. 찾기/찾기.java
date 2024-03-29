import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();
		
		KMP(text, pattern);
		
		System.out.println(count);
		System.out.println(sb);
	}

	private static void KMP(String text, String pattern) {
		int[] table = makeTable(pattern);
		int textSize = text.length();
		int patternSize = pattern.length();
		int j = 0;
		for (int i = 0; i < textSize; i++) {
			while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if (text.charAt(i) == pattern.charAt(j)) {
				if (j == patternSize - 1) {
					sb.append(i - patternSize + 2).append(' ');
					count++;
					j = table[j];
				}else {
					j++;
				}
			}
		}
	}

	private static int[] makeTable(String pattern) {
		int patternSize = pattern.length();
		int[] table = new int[patternSize];
		int j = 0;
		for (int i = 1; i < patternSize; i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				table[i] = ++j;
			}
		}
		return table;
	}
}
