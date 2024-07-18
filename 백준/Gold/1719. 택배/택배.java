import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 2000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Init
        int[][] map = new int[n + 1][n + 1];
        int[][] prev = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prev[i][j] = j;
                map[i][j] = INF;
            }
            map[i][i] = 0;
        }// Init End

        // Input
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map[from][to] = map[to][from] = value;
        }// Input End

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) continue;
                for (int j = 1; j <= n; j++) {
                    int nextValue = map[i][k] + map[k][j];
                    if (nextValue < map[i][j]) {
                        prev[i][j] = prev[i][k];
                        map[i][j] = nextValue;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int p = prev[i][j];
                sb.append(p == i ? "-" : p).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}