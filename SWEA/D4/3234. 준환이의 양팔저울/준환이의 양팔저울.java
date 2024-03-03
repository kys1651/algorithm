import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, sum, result;
    static int[] arr, weight;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            result = 0;
            weight = new int[N];
            arr = new int[N];
            visit = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
                sum += weight[i];
            }

            permutation(0);

            sb.append(String.format("#%d %d\n", tc, result));
        }
        System.out.println(sb);
    }

    private static void permutation(int depth) {
        if (depth == N) {
            combination(1, arr[0], 0, sum - arr[0]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            arr[depth] = weight[i];
            permutation(depth + 1);
            visit[i] = false;
        }
    }

    private static void combination(int depth, int left, int right, int sum) {
        if (right > left) return;

        if (depth == N) {
            result++;
            return;
        }

        if (left >= right + sum) {
            int i = N - depth;
            int count = 1 << i;
            result += count;
            return;
        }

        combination(depth + 1, left, right + arr[depth], sum - arr[depth]);
        combination(depth + 1, left + arr[depth], right, sum - arr[depth]);
    }
}
