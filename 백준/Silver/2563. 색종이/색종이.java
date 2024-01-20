import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[100][100];
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            for (int x = sX; x < sX + 10 && x < 100; x++) {
                for (int y = sY; y < sY + 10 && y < 100; y++) {
                    if (map[x][y] != 1) {
                        map[x][y] = 1;
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
