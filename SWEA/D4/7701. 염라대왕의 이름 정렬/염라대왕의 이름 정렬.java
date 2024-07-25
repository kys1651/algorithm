
import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			TreeSet<String> set = new TreeSet<>((o1, o2) -> {
				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();
				}
				return o1.compareTo(o2);
			});
			while(N --> 0) {
				set.add(br.readLine());
			}
			sb.append('#').append(tc).append('\n');
			for(String s : set) {
				sb.append(s).append('\n');
			}
		}
		System.out.println(sb.toString());
	}

}
