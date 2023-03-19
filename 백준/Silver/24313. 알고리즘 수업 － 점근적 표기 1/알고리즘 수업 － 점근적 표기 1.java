import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean check = true;
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = n ; i <= 100; i++){
            if(!(a1 * i + a0 <= c * i)){
                check = false;
                break;
            }
        }
        System.out.println(check?1:0);
    }
}
