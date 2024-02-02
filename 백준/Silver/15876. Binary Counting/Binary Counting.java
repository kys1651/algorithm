import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Character> list = new ArrayList<>();
		int idx = 0;
		while(list.size() <= 10000) {
			String bin = Integer.toBinaryString(idx++);
			for(char ch : bin.toCharArray()) {
				list.add(ch);
			}
		}
		for(int i = 0; i < 5; i++) {
			sb.append(list.get(k-1 + i * n) + " ");
		}
		System.out.println(sb);
	}

}
