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
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }// Input End

        int M = Integer.parseInt(br.readLine());

        // 공백으로 초기화
        String[][] dp = new String[51][M + 1];
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = EMPTY;
            }
        }

        // 각 길이별로 진행
        for (int i = 1; i <= 50; i++) {
            // 0부터 직접 넣어본다.
            for (int j = 0; j < N; j++) {
                if (i == 1 && j == 0) {
                    continue;
                }

                int spend = prices[j];
//                System.out.println(i + " 길이에 " + j + "를 붙힌 경우 ------");
//                System.out.println("사용 비용 - " + spend);
                for (int k = spend; k <= M; k++) {
                    if (dp[i - 1][k].equals(EMPTY) && j == 0) {
                        continue;
                    }
                    String newValue = dp[i - 1][k] + j;
                    String curValue = dp[i][k - spend];
//                    System.out.println(k + "원인 기존 " + dp[i - 1][k] + "에서 " + spend + "사용해서 " + j + "를 붙힌 경우 : " + newValue);
//                    System.out.println("현재 - " + (k - spend) + " 비용 최대값은 - " + curValue);
                    if (newValue.length() > curValue.length() || (newValue.length() == curValue.length() && newValue.compareTo(curValue) > 0)) {
                        dp[i][k - spend] = newValue;
                    }
//                    System.out.println("갱신된 비용 - " + dp[i][k - spend]);
                }

            }
        }

        String answer = EMPTY;
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= M; j++) {
                int answerLength = answer.length();
                String checkNumber = dp[i][j];
                int dpLength = checkNumber.length();
                if (answerLength < dpLength) {
                    answer = checkNumber;
                } else if (answerLength == dpLength && checkNumber.compareTo(answer) > 0) {
                    answer = checkNumber;
                }
            }
        }

        System.out.println(answer.equals(EMPTY) ? 0 : answer);
    }
}