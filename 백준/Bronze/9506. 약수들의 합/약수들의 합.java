import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = 1;
            if(n == -1) break;

            StringBuilder sb = new StringBuilder();
            sb.append(n + " = 1");
            for(int i = 2; i < n ; i++){
                if(n%i==0){
                    sum += i;
                    sb.append(" + " + i);
                }
            }
            if(sum==n) System.out.println(sb.toString());
            else System.out.println(n + " is NOT perfect.");
        }
    }
}
