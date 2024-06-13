import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final String EMPTY = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N];

        // Input
        int size = 51;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
            if (size > prices[i]) {
                size = prices[i];
            }
        }// Input End

        int M = Integer.parseInt(br.readLine());

        // 공백으로 초기화
        size = (M / size);
        String[][] dp = new String[size + 1][M + 1];
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = EMPTY;
            }
        }

        for (int i = 1; i <= size; i++) {
            boolean exit = true;
            for (int j = 0; j < N; j++) {
                if(i == 1 && j == 0) continue;

                int spend = prices[j];
                for (int k = spend; k <= M; k++) {
                    if (j == 0 && dp[i - 1][k].equals(EMPTY)) {
                        continue;
                    }

                    String newValue = dp[i - 1][k] + j;
                    if (isBig(dp[i][k - spend], newValue)) {
                        dp[i][k - spend] = newValue;
                        exit = false;
                    }
                }
            }
            if(exit) break;
        }

        String answer = EMPTY;
        for (int j = 0; j <= M; j++) {
            if (isBig(answer, dp[size][j])) {
                answer = dp[size][j];
            }
        }

        System.out.println(answer.equals(EMPTY) ? 0 : answer);
    }

    // 더 큰 값 리턴
    private static boolean isBig(String prevValue, String newValue) {
        int prevLen = prevValue.length();
        int newLen = newValue.length();
        if (prevLen > newLen) return false;
        else if (prevLen < newLen) return true;
        else {
            return newValue.compareTo(prevValue) > 0;
        }
    }
}