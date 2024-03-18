import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String input = st.nextToken();
				if(!map.containsKey(input)) {
					map.put(input, 0);
				}
				map.put(input, map.get(input) + 1);
			}
			int answer = 1;
			for (String key : map.keySet()) {
				answer *= (map.get(key) + 1);
			}
			sb.append(answer - 1).append('\n');
		}
		System.out.println(sb);
	}	
}
