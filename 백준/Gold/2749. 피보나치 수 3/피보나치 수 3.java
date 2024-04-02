import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	final static long MOD = 1_000_000L;
	final static long PISANO = 1500000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long idx = Long.parseLong(br.readLine()) % PISANO;
		long[] fibo = new long[(int) idx + 1];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i = 2; i <= idx; i++) {
			fibo[i] = (fibo[i-1] + fibo[i-2]) % MOD;
		}
		System.out.println(fibo[(int)idx]);
	}
}
