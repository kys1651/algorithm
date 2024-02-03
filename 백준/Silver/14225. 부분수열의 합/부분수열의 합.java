import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값 N
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        visit = new boolean[sum + 2];
        combination(0, 0, 0);

        int i = 1;
        for (; visit[i]; i++) {
        }
        System.out.println(i);
    }

    private static void combination(int depth, int at, int sum) {
        if (depth == N) {
            visit[sum] = true;
            return;
        }

        combination(depth + 1, at + 1, sum + arr[at]);
        combination(depth + 1, at + 1, sum);
    }
}
