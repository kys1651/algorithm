import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String keyword = br.readLine();
		if(KMP(input,keyword)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

	private static boolean KMP(String parent, String keyword) {
		int[] table = makeTable(keyword);
		int parentSize = parent.length();
		int keywordSize = keyword.length();
		int j = 0;
		for (int i = 0; i < parentSize; i++) {
			char p = parent.charAt(i);
			if (Character.isDigit(p))
				continue;
			while (j > 0 && p != keyword.charAt(j)) {
				j = table[j - 1];
			}
			if (p == keyword.charAt(j)) {
				if (j == keywordSize - 1) {
					return true;
				} else {
					j++;
				}
			}
		}
		return false;
	}

	private static int[] makeTable(String keyword) {
		int keywordSize = keyword.length();
		int[] table = new int[keywordSize];
		int j = 0;
		for (int i = 1; i < keywordSize; i++) {
			while (j > 0 && keyword.charAt(i) != keyword.charAt(j)) {
				j = table[j - 1];
			}
			if (keyword.charAt(i) == keyword.charAt(j)) {
				table[i] = ++j;
			}
		}
		return table;
	}
}
