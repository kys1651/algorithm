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

        star(n-1, 0, 2 * n, n);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void star(int x, int y, int lenW, int lenH) {
        if (lenW == 6 && lenH == 3) {
            for (int i = 0; i < 5; i++) {
                map[x][y + i] = '*';
            }
            map[x - 1][y + 1] = map[x - 1][y + 3] = map[x - 2][y + 2] = '*';
            return;
        }
        int nextW = lenW / 2;
        int nextH = lenH / 2;
        star(x, y, nextW, nextH);
        star(x, y + nextW, nextW, nextH);
        star(x - nextH, y + nextH, nextW, nextH);
    }
}
