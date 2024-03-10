import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long max = Long.MAX_VALUE;
    static long[] num, answer = new long[3];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // Input
        num = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }// Input End
        Arrays.sort(num);

        for (int i = 0; i < N - 2; i++) {
            solve(i);
        }

        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }

    private static void solve(int idx) {
        int left = idx + 1, right = N - 1;
        while (left < right) {
            long tmp = num[left] + num[right] + num[idx];
            if (Math.abs(tmp) < max) {
                max = Math.abs(tmp);
                answer[0] = num[idx];
                answer[1] = num[left];
                answer[2] = num[right];
            }

            if (tmp < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}
