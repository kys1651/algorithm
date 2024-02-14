import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    static int N, result;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visit = new boolean[N];

        combination(0);

        System.out.println(result);
    }

    private static void combination(int depth) {
        if (depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) continue; // 놓은적 있다면 같은 행 X

            if (isCrossValid(i, depth)) {
                arr[depth] = i;
                visit[i] = true;
                combination(depth + 1);
                visit[i] = false;
            }
        }
    }

    private static boolean isCrossValid(int x, int y) {
        // 대각선 확인
        for (int i = 0; i < y; i++) {
            if (Math.abs(i - y) == Math.abs(arr[i] - x)) {
                return false;
            }
        }
        return true;
    }

}