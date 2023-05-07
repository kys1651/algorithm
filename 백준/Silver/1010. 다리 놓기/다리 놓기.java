import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(solution(m, n)).append('\n');
        }

        System.out.println(sb);
    }

    private static int solution(int n, int r) {
        if(dp[n][r] > 0 )
            return dp[n][r];

        if(n==r||r==0)
            return dp[n][r] = 1;

        return dp[n][r] = solution(n - 1, r - 1) + solution(n - 1, r);
    }
}


