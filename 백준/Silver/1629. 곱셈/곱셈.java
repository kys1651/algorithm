import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(POW(a,b,c));
    }

    private static long POW(long base, long exponent, long mod){
        if(exponent == 1){
            return base % mod;
        }

        long tmp = POW(base,exponent / 2, mod);

        // 홀수일 때 ex) 2^5 -> 2 * 2^2 * 2^2
        if(exponent % 2 == 1){
            return (tmp * tmp % mod) * base % mod;
        }
        // 짝수일 때 ex) 2^8 -> 2^4 * 2^4
        else{
            return tmp * tmp % mod;
        }

    }
}
