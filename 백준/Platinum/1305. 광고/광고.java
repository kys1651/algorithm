import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		int max = makeTable(input);
		System.out.println(N - max);
	}

	private static int makeTable(char[] input) {
		int len = input.length;
		int table[] = new int[len];
		int j = 0;
		for (int i = 1; i < len; i++) {
			while (j > 0 && input[i] != input[j])
				j = table[j - 1];
			if (input[i] == input[j]) {
				table[i] = ++j;
			}
		}
		return table[len - 1];
	}

}
