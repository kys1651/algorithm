import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Input
        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        } // Input End
        Arrays.sort(num);

        int left = 0, right = N - 1;
        int minValue = Integer.MAX_VALUE, minLeft = 0, minRight = 0;
        while (left < right) {
            int tmp = num[right] + num[left];
            if (Math.abs(tmp) < minValue) {
                minValue = Math.abs(tmp);
                minLeft = num[left];
                minRight = num[right];
                if (tmp == 0) break;
            }
            if (tmp < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(minLeft + " " + minRight);
    }
}