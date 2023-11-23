import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n =Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(n --> 0){
            st = new StringTokenizer(br.readLine(),",");
            int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            sb.append(String.valueOf(result)).append("\n");
        }
        System.out.println(sb.toString());
    }
}