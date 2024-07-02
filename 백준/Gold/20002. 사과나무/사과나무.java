import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] sum = new int[N + 1][N + 1];

        // Input
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        } // Input End

        int answer = -90_000_001;
        for (int k = 1; k <= N; k++) {
            for (int i = k; i <= N; i++) {
                for(int j = k; j <= N; j++) {
                    int value = sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k];
                    answer = Math.max(value, answer);
                }
            }
        }
        System.out.println(answer);
    }
}