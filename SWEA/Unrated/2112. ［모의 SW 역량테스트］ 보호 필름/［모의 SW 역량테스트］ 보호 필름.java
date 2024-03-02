import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int D, W, K, result;
    static int[][] map,copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            result = D;
            // Input
            map = new int[D][W];
            copyMap = new int[D][W];
            for (int i = 0; i < D; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = input.charAt(j * 2) - '0';
                    copyMap[i][j] = map[i][j];
                }
            }// Input End

            if (isValid()) {
                sb.append(String.format("#%d %d\n", tc, 0));
                continue;
            }

            permutation(0, 0);
            sb.append(String.format("#%d %d\n", tc, result));
        }
        System.out.println(sb);
    }

    private static void permutation(int depth, int count) {
        if (result <= count) {
            return;
        }

        if (depth == D) {
            if (isValid()) {
                result = Math.min(count, result);
            }
            return;
        }

        permutation(depth + 1, count);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < W; j++) {
                map[depth][j] = i;
            }
            permutation(depth + 1, count + 1);
        }
        // 기본 상태로 복구
        for (int i = 0; i < W; i++) {
            map[depth][i] = copyMap[depth][i];
        }
    }

    private static boolean isValid() {
        for (int i = 0; i < W; i++) {
            int count = 0;
            int prev = map[0][i]; // 첫번째 기준으로 잡음
            for (int j = 0; j < D; j++) {
                if (prev == map[j][i]) {
                    count++;
                    if (count == K)
                        break;
                } else {
                    count = 1;
                    prev = map[j][i];
                }
            }
            if (count != K) {
                return false;
            }
        }
        return true;
    }
}
