import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] S = new int[301];
        int[][] DP = new int[301][3];

        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(br.readLine());
        }

        DP[1][1] = S[1];
        DP[1][2] = 0;
        DP[2][1] = S[2];
        DP[2][2] = S[1] + S[2];
        for (int i = 3; i <= N; i++) {
            DP[i][1] = Math.max(DP[i - 2][1], DP[i - 2][2]) + S[i];
            DP[i][2] = DP[i - 1][1] + S[i];
        }

        System.out.println(Math.max(DP[N][1], DP[N][2]));

    }
}
