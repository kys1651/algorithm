import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 0) {
			System.out.println(0);
			return;
		}
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		for(int i = 2; i <= N; i++) {
			BigInteger tmp = a.add(b);
			a = b;
			b = tmp;
		}
		System.out.println(b);
	}
}
