import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Input
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        isQuadTree(0, 0, n);

        System.out.println(sb);
    }

    private static void isQuadTree(int x, int y, int n) {
        if (isEqual(x, y, n)) {
            sb.append(map[x][y]);
            return;
        }

        sb.append('(');
        int nextLen = n >> 1;
        isQuadTree(x, y, nextLen);
        isQuadTree(x, y + nextLen, nextLen);
        isQuadTree(x + nextLen, y, nextLen);
        isQuadTree(x + nextLen, y + nextLen, nextLen);
        sb.append(')');
    }

    private static boolean isEqual(int x, int y, int n) {
        char bit = map[x][y];

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (bit != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}