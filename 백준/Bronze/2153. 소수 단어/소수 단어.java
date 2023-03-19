import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();

        int sum = 0;
        for(int i = 0 ; i < str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isLowerCase(ch)){
                sum += (ch - 'a') + 1;
            }else{
                sum += (ch - 'A') + 27;
            }
        }
        BigInteger b = BigInteger.valueOf(sum);
        if (b.isProbablePrime(10)||sum == 1) {
            System.out.println("It is a prime word.");
        }else{
            System.out.println("It is not a prime word.");
        }


    }
}