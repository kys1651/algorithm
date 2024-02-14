import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visit = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] != 0) {
                visit[arr[i]] = true;
            }
        }

        combination(1);

        System.out.println(-1);
    }

    private static void combination(int depth) {
        if (depth == N + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                sb.append(arr[i]).append(' ');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (arr[depth] != 0) {
            combination(depth + 1);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue; // 놓은적 있다면 같은 행 X

            if (isCrossValid(i, depth)) {
                arr[depth] = i;
                visit[i] = true;
                combination(depth + 1);
                visit[i] = false;
                arr[depth] = 0;
            }
        }
    }

    private static boolean isCrossValid(int x, int y) {
        // 대각선 확인
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) continue;
            if (Math.abs(i - y) == Math.abs(arr[i] - x)) {
                return false;
            }
        }
        return true;
    }

}