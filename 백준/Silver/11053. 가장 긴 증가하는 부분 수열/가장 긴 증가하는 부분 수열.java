import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        for (int i = 0; i < N; i++) {
            int value = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    value = Math.max(dp[j], value);
                }
            }
            dp[i] = value + 1;
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
