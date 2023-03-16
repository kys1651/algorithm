import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n; i++){
            str = br.readLine();
            System.out.println(str.charAt(0) + "" + str.charAt(str.length() - 1));
        }
    }
}