import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    static int [] arr;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /*
            1. 마지막 계단은 무조건 밟아야한다. ( arr[N] 번째)
            2. N-1,N-2 둘 중 하나로 끝난다.
            3. N-1로 끝나면 N-2는 밟을 수 없다.
         */
        dp[1] = arr[1];

        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        for (int i = 3; i <= N; i++) {
            // dp[두칸 전] 값과 dp[첫칸 전] + dp[셋째칸의 전] 중 큰  + 현재 계단의 값
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];

        }


        System.out.println(dp[N]);
    }
}
