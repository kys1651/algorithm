import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < t; i++){
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            BigInteger b = BigInteger.valueOf(n);

            if(b.isProbablePrime(10)){
                System.out.println(n);
            }else{
                System.out.println(b.nextProbablePrime());
            }

        }
    }
}