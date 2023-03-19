import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int x = (a * d) + (c * b);
        int y = b * d;

        int max = Math.max(x, y);
        int min = Math.min(x, y);
        while (min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }
        System.out.println(x/max + " " + y/max);
    }
}


