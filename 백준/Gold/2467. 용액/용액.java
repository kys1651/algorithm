import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }// Input End

        int left = 0, right = N - 1;
        int a = 0, b = 0;
        int maxSum = Integer.MAX_VALUE;
        while (left < right) {
            int tmpSum = num[left] + num[right];
            if (Math.abs(tmpSum) < maxSum) {
                maxSum = Math.abs(tmpSum);
                a = num[left];
                b = num[right];
            }

            // 0보다 작으면 크기를 키워야 함
            if (tmpSum < 0) {
                left++;
            }
            // 0보다 크면 줄여야 함
            else {
                right--;
            }
        }
        System.out.println(a + " " + b);
    }
}
