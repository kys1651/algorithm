import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n * 2];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], ' ');
        }

        star(n - 1, 0, n * 2);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void star(int x, int y, int len) {
        if (len == 6) {
            // 밑 한 줄
            map[x][y] = map[x][y+1] = map[x][y+2] = map[x][y+3] = map[x][y+4] = '*';
            map[x - 1][y + 1] = map[x - 1][y + 3] = map[x - 2][y + 2] = '*';
            return;
        }
        int nextLen = len / 2;
        star(x, y, nextLen);
        star(x, y + nextLen, nextLen);
        star(x - nextLen / 2, y + nextLen / 2, nextLen);
    }
}
