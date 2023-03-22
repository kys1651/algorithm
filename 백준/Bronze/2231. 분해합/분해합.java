import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = Integer.parseInt(br.readLine());
        int n = result;
        int answer = 0;
        while(n > 0){
            String tmp = String.valueOf(n);
            int sum = 0;

            for(int i = 0 ; i < tmp.length(); i++){
                sum += tmp.charAt(i) - '0';
            }
            sum += n;
            if(sum == result) answer = n;
            n--;
        }
        System.out.println(answer);
    }
}