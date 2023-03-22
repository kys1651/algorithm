import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0 ; i < n ; i++){
            int a = i, b = 0;
            while(a != 0){
                b += a%10;
                a /= 10;
            }
            if(i+b==n){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}