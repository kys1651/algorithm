import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static boolean isPrime(long n){
        for(long i = 2; i <= Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < t; i++){
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            if(n==1||n==0) n = 2;
            while(!isPrime(n)) n++;
            System.out.println(n);
        }
    }
}