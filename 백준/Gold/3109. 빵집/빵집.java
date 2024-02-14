import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // Input
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean dfs(int x, int y) {
        map[x][y] = 'x';

        if (y == C - 1) {
            return true;
        }

        if (x > 0 && map[x - 1][y + 1] == '.') {
            if (dfs(x - 1, y + 1)) return true;
        }
        if (map[x][y + 1] == '.') {
            if (dfs(x, y + 1)) return true;
        }
        if (x < R - 1 && map[x + 1][y + 1] == '.') {
            if (dfs(x + 1, y + 1)) return true;
        }
        return false;
    }
}