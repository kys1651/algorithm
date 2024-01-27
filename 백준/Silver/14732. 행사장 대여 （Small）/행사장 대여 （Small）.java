import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] map = new boolean[500][500];
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int count = 0;
        for (int k = 0; k < n; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    if (map[i][j]) { continue; }
                    map[i][j] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}