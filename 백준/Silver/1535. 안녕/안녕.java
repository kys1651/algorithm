import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Input
        int[][] input = new int[N + 1][2];
        String[] lossHp = br.readLine().split(" ");
        String[] add = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            input[i][0] = Integer.parseInt(lossHp[i - 1]);
            input[i][1] = Integer.parseInt(add[i - 1]);
        }// Input End

        int[] dp = new int[101];
        for (int i = 1; i <= N; i++) {
            for (int j = 100; j >= input[i][0] + 1; j--) {
                dp[j] = Math.max(dp[j], dp[j - input[i][0]] + input[i][1]);
            }
        }

        int answer = 0;
        for (int i = 1; i <= 100; i++) answer = Math.max(answer, dp[i]);
        System.out.println(answer);
    }
}