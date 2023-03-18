import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int i = 1;
        int count = 1;
        while(k != 0){
            if(n%i==0) {
                k--;
            }else{
                count++;
            }
            i++;
            if(count > n) {
                i = 1;
                break;
            }
        }
        System.out.println(i-1);
    }
}
