import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int maxx = -10000;
        int minx = 10000;
        int maxy = -10000;
        int miny = 10000;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(maxx < a) maxx = a;
            if(minx > a) minx = a;
            if(maxy < b) maxy = b;
            if(miny > b) miny = b;

        }
        System.out.println((maxx - minx) * (maxy - miny));
    }
}