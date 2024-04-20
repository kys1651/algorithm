import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            int count = 0;
            boolean zero = false;
            while (!(zero && answer == 511)) {
                count++;
                int tmp = N * count;
                while (tmp != 0) {
                    if (tmp % 10 == 0) {
                        zero = true;
                        tmp /= 10;
                        continue;
                    }
                    int digit = tmp % 10;
                    answer |= (1 << (digit - 1));
                    tmp /= 10;
                }
            }
            sb.append(String.format("#%d %d\n",tc,count * N));
        }
        System.out.println(sb);
    }
}
