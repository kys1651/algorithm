import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        if (N == H) {
            System.out.println(1);
            return;
        }

        int size = Math.abs(N - H) + 1;
        long[][] dp = new long[size][size];

        // 0,0에서 같은 행은 쭉 가면된다. 갈 수 있는 경로 1
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < size; i++) {
            for (int j = i; j < size; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        System.out.println(dp[size - 1][size - 1]);

    }
}

