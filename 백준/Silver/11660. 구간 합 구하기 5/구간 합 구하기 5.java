import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Input
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + value;
            }
        }// Input End

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken()) - 1;
            int sY = Integer.parseInt(st.nextToken()) - 1;
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());
            int sum = map[eX][eY] - map[sX][eY] - map[eX][sY] + map[sX][sY];
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
