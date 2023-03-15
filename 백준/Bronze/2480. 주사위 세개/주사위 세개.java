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
        int c = Integer.parseInt(st.nextToken());
        int answer = 0;

        if(a==b&&b==c) answer = 10000+a*1000;
        else if(a==b||a==c) answer = 1000+a*100;
        else if(b==c) answer = 1000+b*100;
        else answer = Math.max(a, Math.max(b, c))*100;

        System.out.println(answer);
    }
}