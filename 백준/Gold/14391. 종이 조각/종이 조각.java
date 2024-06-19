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

        boolean[][] copy = new boolean[N][M];
        getCopy(copy, visit);

        // 가로 확인
        int tmp = 0;
        for (int i = x; i < N; i++) {
            if(visit[i][y]) break;
            tmp *= 10;
            tmp += map[i][y];
            visit[i][y] = true;
            solve(x, y + 1, value + tmp);
        }

        tmp = 0;
        getCopy(visit, copy);
        for (int j = y; j < M; j++) {
            if(visit[x][j]) break;
            tmp *= 10;
            tmp += map[x][j];
            visit[x][j] = true;
            solve(x, y + 1, value + tmp);
        }

        getCopy(visit, copy);
    }

    private static void getCopy(boolean[][] a, boolean[][] b) {
        for (int i = 0; i < N; i++) {
            System.arraycopy(b[i], 0, a[i], 0, M);
        }
    }


}