import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] peoples = new int[6];
        for (int i = 0; i < 6; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < 6; i++) {
            result += peoples[i] / T + (peoples[i] % T == 0 ? 0 : 1);
        }
        System.out.println(result);
        System.out.println(N / P + " " + (N % P));
    }
}
