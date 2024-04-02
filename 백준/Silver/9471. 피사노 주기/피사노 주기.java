import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	final static int MOD = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int a = 0;
			int b = 1;
			int count = 1;
			while(true) {
				int next = (a + b) % m;
				a = b;
				b = next;
				count++;
				if(a == 1 && b == 0) {
					break;
				}
			}
			sb.append(String.format("%d %d\n",P,count));
		}
		System.out.println(sb);
	}
}
