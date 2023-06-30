import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
import java.util.*;

public class Main {

    final static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;
        int result = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }

            result = Math.max(result, dp[i]);
        }

        int value = result;
        // 역추적
        Stack<Integer> stack = new Stack<>();

        for (int i = N; i >= 1; i--) {
            if(value == dp[i]){
                stack.push(arr[i]);
                value--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(result);
        System.out.println(sb.toString());
    }
}
