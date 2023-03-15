import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        str = br.readLine();
        st = new StringTokenizer(str);
        int c = Integer.parseInt(st.nextToken());

        a += (b+c)/60;
        b = (b+c)%60;
        System.out.println(a%24+ " "+b);
    }
}