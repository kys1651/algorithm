import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String separ = ", ";
		short n = Short.parseShort(st.nextToken());
		short k = (short) (Short.parseShort(st.nextToken()) - 1);
		ArrayList<Short> list = new ArrayList<>();
		for (short i = 1; i <= n; i++) {
			list.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		int idx = 0;
		while (n != 0) {
			idx = (idx + k) % n;
			sb.append(list.get(idx));
			if(n != 1) sb.append(separ);
			list.remove(idx);
			n--;
		}
		sb.append('>');
		System.out.println(sb);
	}
}
