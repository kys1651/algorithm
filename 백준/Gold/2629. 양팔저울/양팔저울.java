import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int size = 0;
        int[] c = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            size += c[i];
        }

        boolean[] check = new boolean[size + 1];
        check[c[0]] = true;
        for (int i = 1; i < N; i++) {
            int tmp = c[i];
            for (int j = size; j >= 1; j--) {
                if(check[j]) check[j+tmp] = true;
            }
            for (int j = 1; j <= size; j++) {
                if(check[j]) check[Math.abs(j - tmp)] = true;
            }
            check[tmp] = true;
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp > size || !check[tmp]) sb.append("N ");
            else sb.append("Y ");
        }
        System.out.println(sb);
    }
}
