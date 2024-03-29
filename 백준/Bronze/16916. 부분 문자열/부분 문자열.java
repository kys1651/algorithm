import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String keyword = br.readLine();
		KMP(input, keyword);

	}

	private static void KMP(String parent, String keyword) {
		int[] table = makeTable(keyword);
		int parentSize = parent.length();
		int keywordSize = keyword.length();
		int j = 0;
		for (int i = 0; i < parentSize; i++) {
			// 일치하지 않는다면 일치하는 곳으로 되돌아간다.
			while (j > 0 && parent.charAt(i) != keyword.charAt(j)) {
				j = table[j - 1];
			}
			if (parent.charAt(i) == keyword.charAt(j)) {
				// 찾아야 할 단어의 끝 길이면 발견한 것
				if (j == keywordSize - 1) {
					System.out.println("1");
					return;
				}
				// 아니라면 j만 증가
				else {
					j++;
				}
			}
		}
		System.out.println("0");
	}

	// 접두사와 접미사가 일치하는 최대 길이를 찾아주는 메서드
	private static int[] makeTable(String keyword) {
		int keywordSize = keyword.length();
		int[] table = new int[keywordSize];
		int j = 0;
		for (int i = 1; i < keywordSize; i++) {
			// 일치했던 부분까지 되돌아감
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
