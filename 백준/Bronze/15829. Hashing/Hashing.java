import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int M = 1234567891;
        final int r = 31;
        int L = Integer.valueOf(br.readLine());
        String word = br.readLine();

        int result = 0;
        for(int i = 0; i < L; i++){
            int n = word.charAt(i) - 'a' + 1;
            result += n * Math.pow(r,i) % M;
        }
        System.out.println(result);
    }
}
