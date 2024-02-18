import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static int N, M, answer = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'W') {
                    map[i][j] = true;
                }
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                checkValid(i, j);
            }
        }

        System.out.println(answer);
    }

    private static void checkValid(int x, int y) {
        int wStart = 0;
        int bStart = 0;
        boolean flag = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (flag != map[x + i][y + j]) {
                    wStart++;
                }
                if (!flag != map[x + i][y + j]) {
                    bStart++;
                }
                flag = !flag;
            }
            flag = !flag;
        }
        if (wStart < answer) {
            answer = wStart;
        }
        if (bStart < answer) {
            answer = bStart;
        }

        if (answer == 0) {
            System.out.println(0);
            System.exit(0);
        }
    }
}

