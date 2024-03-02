import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] map = new int[10][10];
    static int result = Integer.MAX_VALUE;
    static int[] paper = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(paper, 5);

        // Input
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            String input = br.readLine();
            for (int j = 0; j < 10; j++) {
                map[i][j] = input.charAt(2 * j) - '0';
            }
        } // Input End

        solve(0, 0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void solve(int x, int y, int count) {
        if (x == 9 && y == 10) {
            result = Math.min(result, count);
            return;
        }

        if (count >= result) {
            return;
        }

        if (y == 10) {
            solve(x + 1, 0, count);
            return;
        }

        if (map[x][y] == 0) {
            solve(x, y + 1, count);
            return;
        }

        for (int i = 5; i >= 1; i--) {
            if (paper[i] > 0 && isCan(x, y, i)) {
                fill(x, y, i, 0);
                paper[i]--;
                solve(x, y, count + 1);
                fill(x, y, i, 1);
                paper[i]++;
            }
        }
    }

    private static void fill(int x, int y, int depth, int value) {
        for (int i = x; i < x + depth && i < 10; i++) {
            for (int j = y; j < y + depth && j < 10; j++) {
                map[i][j] = value;
            }
        }
    }

    private static boolean isCan(int x, int y, int depth) {
        for (int i = x; i < x + depth; i++) {
            for (int j = y; j < y + depth; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10 || map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
