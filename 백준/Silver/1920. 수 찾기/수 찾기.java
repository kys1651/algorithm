import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		while (M-- > 0) {
			int tmp = Integer.parseInt(st.nextToken());
			if(set.contains(tmp)) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
