import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static char[] bit;
	static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		size = n * 5;
		
		getBits();

		for (int i = 0; i < 5; i++) {
			sb.append(bit[k - 1 + i * n] + " ");
		}
		
		System.out.println(sb);
	}

	private static void getBits() {
		bit = new char[size];
		int i = 0, idx = 0;
		while (true) {
			String binStr = Integer.toBinaryString(idx++);
			for (char ch : binStr.toCharArray()) {
				bit[i++] = ch;
				if (i >= size) {
					return;
				}
			}
		}
	}

}
