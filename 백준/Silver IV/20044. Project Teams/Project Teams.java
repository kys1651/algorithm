import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[2 * N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int nextValue = nums[i] + nums[2 * N - i - 1];
            if (nextValue < answer) {
                answer = nextValue;
            }
        }
        System.out.println(answer);
    }
}

