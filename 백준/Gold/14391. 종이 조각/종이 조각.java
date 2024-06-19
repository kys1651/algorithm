import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        solve(0, 0, 0);
        System.out.println(answer);
    }

    private static void solve(int x, int y, int value) {
        if (x == N) {
            answer = Math.max(answer, value);
            return;
        }
        if (y == M) {
            solve(x + 1, 0, value);
            return;
        }
        if (visit[x][y]) {
            solve(x, y + 1, value);
            return;
        }

        int tmp = map[x][y];
        visit[x][y] = true;
        solve(x, y + 1, value + tmp);
        visit[x][y] = false;

        // 가로 확인
        int i = 1;
        for (; x + i < N; i++) {
            int nX = x + i;
            if (visit[nX][y]) break;

            tmp *= 10;
            tmp += map[nX][y];
            visit[nX][y] = true;
            solve(x, y + 1, value + tmp);
        }
        for(int j = 1; j < i; j++) visit[x + j][y] = false;

        tmp = map[x][y];
        i = 1;
        for (; y + i < M; i++) {
            int nY = y + i;
            if (visit[x][nY]) break;

            tmp *= 10;
            tmp += map[x][nY];
            visit[x][nY] = true;
            solve(x, y + 1, value + tmp);
        }
        for (int j = 1; j < i; j++) visit[x][y + j] = false;
    }
}