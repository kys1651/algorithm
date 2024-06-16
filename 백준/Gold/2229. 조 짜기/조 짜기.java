import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Input
        int[] dp = new int[N + 1];
        int[] scores = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }// Input End

        for (int i = 1; i <= N; i++) {
            int max = scores[i];
            int min = scores[i];
            for (int j = i; j >= 1; j--) {
                max = Math.max(max, scores[j]);
                min = Math.min(min, scores[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
            }
        }

        System.out.println(dp[N]);
    }
}