import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long s = Integer.parseInt(st.nextToken());
		
		if(2 * w < s) {
			System.out.println((x + y) * w);
			return;
		}
		
		long answer = Math.min(x, y) * s;
		long mod = Math.abs(x-y);
		if(mod % 2 != 0) {
			answer += w;
			mod--;
		}
		
		System.out.println(answer + mod * (Math.min(w, s)));
		
	}

}
