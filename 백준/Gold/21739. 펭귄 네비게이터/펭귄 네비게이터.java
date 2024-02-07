import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger nFac = new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            nFac = nFac.multiply(BigInteger.valueOf(i));
        }

        BigInteger head = nFac;
        for (int i = N + 1; i <= N * 2; i++) {
            head = head.multiply(BigInteger.valueOf(i));
        }

        BigInteger answer = head.divide(nFac).divide(nFac.multiply(BigInteger.valueOf(N + 1))).mod(new BigInteger("1000000007"));
        System.out.println(answer);

    }
}

