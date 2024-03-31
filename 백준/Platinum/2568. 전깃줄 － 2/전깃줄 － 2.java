import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Wire {
        int from;
        int to;

        public Wire(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Wire[] wires = new Wire[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            wires[i] = new Wire(from, to);
        }
        Arrays.sort(wires, (o1, o2) -> o1.from == o2.from ? o2.to - o1.to : o1.from - o2.from);

        int[] dp = new int[N];
        int[] next = new int[N];
        dp[0] = wires[0].to;
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (dp[count - 1] < wires[i].to) {
                next[i] = count;
                dp[count++] = wires[i].to;
            } else if (dp[0] > wires[i].to) {
                dp[0] = wires[i].to;
                next[i] = 0;
            } else {
                int idx = binary(0, count - 1, dp, wires[i].to);
                dp[idx] = wires[i].to;
                next[i] = idx;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(N - count).append('\n');
        count--;
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if(next[i] == count){
                count--;
            }else{
                stack.push(wires[i].from);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append('\n');
        }
        System.out.println(sb);
    }

    private static int binary(int left, int right, int[] dp, int key) {
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (dp[mid] < key) {
                left = mid + 1;
            } else if (dp[mid] > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
