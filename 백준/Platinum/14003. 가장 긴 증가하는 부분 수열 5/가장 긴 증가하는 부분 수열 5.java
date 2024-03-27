import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        int[] LIS = new int[N];
        int[] answer = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            input[i] = value;

            if (i == 0) {
                LIS[count++] = value;
            } else {
                // 방금 들어온 값이 큼
                if (LIS[count - 1] < value) {
                    answer[i] = count;
                    LIS[count++] = value;
                } else if (LIS[0] > value) {
                    LIS[0] = value;
                    answer[i] = 0;
                } else {
                    int idx = binary(0, count - 1, LIS, value);
                    answer[i] = idx;
                    LIS[idx] = value;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        Stack<Integer> stack = new Stack<>();
        int idx = count - 1;
        for (int i = N-1; i >= 0; i--) {
            if(idx == answer[i]){
                stack.push(input[i]);
                idx--;
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop()).append(' ');
        System.out.println(sb);
    }

    private static int binary(int left, int right, int[] LIS, int value) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (LIS[mid] < value) {
                left = mid + 1;
            } else if (LIS[mid] > value) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
