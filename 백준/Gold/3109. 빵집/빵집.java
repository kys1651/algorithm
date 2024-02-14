import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean exit;

    static int[] dirX = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            exit = false;
            dfs(i, 0);
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            if (map[i][C - 1] == 'x') {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        map[x][y] = 'x';

        if (y == C - 1) {
            exit = true;
            return;
        }

        if (!exit && x > 0 && map[x - 1][y + 1] == '.') {
            dfs(x - 1, y + 1);
        }
        if (!exit && map[x][y + 1] == '.') {
            dfs(x, y + 1);
        }
        if (!exit && x < R - 1 && map[x + 1][y + 1] == '.') {
            dfs(x + 1, y + 1);
        }
    }
}