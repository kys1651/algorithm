import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] count = new long[N - 1][21];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int value = Integer.parseInt(st.nextToken());
        count[0][value]++;
        for (int i = 1; i < N - 1; i++) {
            value = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= 20; j++) {
                if (count[i - 1][j] == 0) continue;

                int next = j + value;
                if (next <= 20) {
                    count[i][next] += count[i - 1][j];
                }

                next = j - value;
                if (next >= 0) {
                    count[i][next] += count[i - 1][j];
                }
            }
        }
        int end = Integer.parseInt(st.nextToken());
        System.out.println(count[N - 2][end]);
    }
}