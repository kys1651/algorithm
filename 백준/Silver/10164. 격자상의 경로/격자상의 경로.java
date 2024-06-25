import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (K == 0) {
            System.out.println(getDist(N, M));
        } else {
            int a = (K / M) + 1;
            int b = K % M;
            System.out.println(getDist(a, b) * getDist(N - a + 1, M - b + 1));
        }
    }

    private static int getDist(int x, int y) {
        int[][] dp = new int[x + 1][y + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[x][y];
    }
}