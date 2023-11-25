import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] rDp = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 배열
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        // 내림차순 배열
        for (int i = n - 1; i >= 0; i--) {
            rDp[i] = 1;
            for (int j = n - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && rDp[j] + 1 > rDp[i]) {
                    rDp[i] = rDp[j] + 1;
                }
            }
        }
        // 각 배열을 합쳐준다. 1을 빼는 이유는 원소가 1개씩 겹치기 때문에
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i] + rDp[i]);
        }
        System.out.println(max - 1);
    }
}
