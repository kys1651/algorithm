import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (j != 0) {
                    map[i][j] += map[i][j-1];
                }
                if (i != 0) {
                    map[i][j] += map[i-1][j];
                }
                if (i != 0 && j != 0) {
                    map[i][j] -= map[i-1][j-1];
                }
                map[i][j] += value;
            }
        }
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            int tmp = map[endX][endY];
            if (startX != 0) {
                tmp -= map[startX - 1][endY];
            }
            if (startY != 0) {
                tmp -= map[endX][startY - 1];
            }
            if (startX != 0 && startY != 0) {
                tmp += map[startX - 1][startY - 1];
            }
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }
}
