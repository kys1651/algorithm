import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int total = (1 << 10) - 1;
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            int count = 0;
            for (count = 1; ; count++) {
                char[] arr = String.valueOf(N * count).toCharArray();
                for (char c : arr) {
                    int digit = c - '0';
                    answer |= (1 << digit);
                }
                if(answer == total) break;
            }
            sb.append(String.format("#%d %d\n", tc, count * N));
        }
        System.out.println(sb);
    }
}
