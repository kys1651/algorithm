import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i],' ');
        }
        starPrint(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map[i]).append('\n');
        }

        System.out.println(sb);
    }

    private static void starPrint(int x, int y, int len) {
        if (len == 1) {
            map[x][y] = '*';
            return;
        }

        int nextLen = len / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                starPrint(x + i * nextLen, y + j * nextLen, nextLen);
            }
        }
    }
}

