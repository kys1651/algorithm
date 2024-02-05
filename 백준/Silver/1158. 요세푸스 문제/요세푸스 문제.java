import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()) - 1;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		int idx = 0;
		while(list.size() != 1) {
			idx = (idx + k) % list.size();
			sb.append(list.get(idx)).append(',').append(' ');
			list.remove(idx);
		}
		sb.append(list.get(0)).append('>');
		System.out.println(sb);
	}
}
